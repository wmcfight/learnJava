/**
 * <p> @(#)maxPoint.java, 2014-1-2. </p>
 * 
 * Copyright 2014 RenRen, Inc. All rights reserved.
 */
package learnJava;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;



/**
 * 
 * @author wmc
 * 
 */
public class maxPoint {
	
	private static Map<Point,Integer> mData = new HashMap<Point, Integer>();
	private static Map<Point,HashSet<Point>> mResult = new HashMap<Point, HashSet<Point>>();
	public int maxPoints(Point[] points) {
	    int iMax = getUnique(points);
	    if(mData.size() <=1) return iMax;
	    Set<Point> uSet = new HashSet<Point>();
	    Set<Point> ubSet = new HashSet<Point>();
	    for(int i=0;i!=points.length-1;++i){
	    	if (uSet.contains(points[i])) {
				continue;
			}
	    	uSet.contains(points[i]);
	    	ubSet.clear();
	    	for (int j=i+1;j!=points.length;++j) {
	    		if (ubSet.contains(points[j])) {
					continue;
				}
	    		ubSet.add(points[j]);
	    		getSlope(points[i], points[j]);
			}
	    }
		iMax = max(getMax(), iMax);
		return iMax;

	}
	
	private int getMax(){
		Iterator iter = mResult.entrySet().iterator();
		int iMax = 0;
		while(iter.hasNext()){
			HashSet<Point> item = (HashSet<Point>)((Map.Entry)iter.next()).getValue();
			int temp = 0;
			for (Point pitem : item) {
				temp += mData.get(pitem);
			}
			iMax = max(temp, iMax);
		}
		return iMax;
	}
	
	private void getSlope(Point A,Point B){
		if(A.x == B.x) {
			update(new Point(A.x,0), A, B);
			return ;
		}
		if (A.y == B.y) {
			update(new Point(0,A.y), A, B);
			return ;
		}
		
		int sX = A.x >= B.x ? (A.x-B.x) : (B.x-A.x);
		int sY = A.x >= B.x ? (A.y-B.y) : (B.y-A.y);
		int gcdR = getGcd(sX, Math.abs(sY));
		update(new Point(sX/gcdR,sY/gcdR), A, B);
	}
	
	private void update(Point result,Point A,Point B){
		HashSet<Point> rSet = mResult.get(result);
		if (mResult.containsKey(result)) {
			System.out.println("Yes");
		}else {
			System.out.println("No");
		}
		if (rSet == null) {
			rSet = new HashSet<Point>();
		}
		rSet.add(A);
		rSet.add(B);
		mResult.put(result, rSet);
	}  
	
	private int getGcd(int x,int y)
	{
		if(x%y == 0) return y;
		else return getGcd(y, x%y);
	}
	
	private int getUnique(Point[] points){
		int iMax = 0;
		int result = 0;
		for (Point item:points) {
			if (mData.get(item) != null) {
				result = mData.get(item)+1;
			}
			else {
				result = 1;
			}
			
			iMax = max(iMax, result);
			mData.put(item, result);
		}
		return iMax;
	}
	
	private int max(int a,int b){
		return a>b?a:b;
	}
	
	public static void main(String[] args) {
		Point[] dataPoints = {new Point(0,0),
				              new Point(1,1),
		new Point(2,2)};
		maxPoint handler = new maxPoint();
		System.out.println(handler.maxPoints(dataPoints));
	}
}

class Point {
	int x;
	int y;

	Point() {

		x = 0;
		y = 0;// TODO Auto-generated constructor stub
	}

	Point(int a, int b) {
		x = a;
		y = b;
	}

}
