package main.routing.algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import screen.main.GoGatorActivity;

public class CampusMap {
	
	private static RoutesMap map;
	private static MyGeoPoint gp;
	private static MyGeoPoint[] mygp;
	
	public CampusMap(){
		
	}
	
	public static RoutesMap generateCampusMap(){
		//Calling constructor to Initialize value in Class
		gp = new MyGeoPoint();
		//Fetching all GeoPoint data
		mygp = MyGeoPoint.getMygp();
		//Number of routes to be added
		map = new DenseRoutesMap(MyGeoPoint.getPathFrags());
		for(int i=0;i<mygp.length;i++){
			//List of neighbors
			List<MyGeoPoint> myngp = mygp[i].getMyngp();
			
			for(MyGeoPoint neighborgp: myngp)
				map.addDirectRoute(mygp[i],neighborgp, MyGeoPoint.getDistance(mygp[i],neighborgp));
		}
		System.out.println("Graph Generated!!");
		return map;
	}
	
	public static ArrayList<MyGeoPoint> findShortestPath(MyGeoPoint source, MyGeoPoint destination){
		
		
        //Find distance between all points.
//		engine.execute(source, null);
//		System.out.println("Path calc over");
		
//		new Thread(new Runnable() {
//            public void run() {
//            	engine.execute(source, null);
//            	System.out.println("Path calc over");
//            }
//          }).start();
//	
		System.out.println("Source"+source);
		System.out.println("Destination"+destination);
		//Now find path to with the destination
		DijkstraEngine engine = GoGatorActivity.getEngine();
		engine.execute(source, destination);
        ArrayList<MyGeoPoint> mygps = new ArrayList<MyGeoPoint>();
		 
		  for (MyGeoPoint mygp = destination; mygp != null; mygp = engine.getPredecessor(mygp))
		  {
			  mygps.add(mygp);
		  }
		 
		  Collections.reverse(mygps);
		 
		  return mygps;
	}
}
