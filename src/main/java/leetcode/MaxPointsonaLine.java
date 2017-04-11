package leetcode;

/*
Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.

 public:
        int maxPoints(vector<Point> &points){
            map<pair<int,int>,int> mResult;
            map<pair<double,double>,set<pair<int,int> > > sResult;
            map<pair<double,double>,set<pair<int,int> > > zResult;
            double slope = 0;
			double dis = 0;
            int nMax = getUnique(points,mResult);
            if(mResult.size()<=1) return nMax;
            for(map<pair<int,int>,int>::iterator iter = mResult.begin();iter!=mResult.end();++iter){
                map<pair<int,int>,int>::iterator jter = iter;
                jter++;
                while(jter!=mResult.end()){
                	int type = getSlope(Point(iter->first.first,iter->first.second),
                                Point(jter->first.first,jter->first.second),slope,dis);
                	switch(type)
                                {
                                	case 1:{
                                		sResult[make_pair(slope,dis)].insert(iter->first);
                                        sResult[make_pair(slope,dis)].insert(jter->first);
                                		break;
                                	}

                                	case 2:
                                		{
                                			zResult[make_pair(slope,dis)].insert(iter->first);
                        				    zResult[make_pair(slope,dis)].insert(jter->first);
                                		}

                                		break;

                                }

                    jter++;
                }
            }

            nMax = max(nMax,getMax(mResult,sResult,1));
            nMax = max(nMax,getMax(mResult,zResult,2));
          //  nMax = max(nMax,getMax(mResult,hResult,3));


            return nMax;
        }

    private:
        int getMax(map<pair<int,int>,int>&mData, map<pair<double,double>,set<pair<int,int> > >&sData,int type){
            int nMax = 0;
            for(map<pair<double,double>,set<pair<int,int> > >::iterator iter = sData.begin();iter!=sData.end();++iter){

            	//printf("type %d slope is %f re is %d \n",type,iter->first,iter->second.size());
                int temp = 0;
                for(set<pair<int,int> >::iterator jter = iter->second.begin();jter!=iter->second.end();++jter){
                  temp += mData[*jter];

                }
                nMax = max(nMax,temp);
            }
            return nMax;
        }
        pair<int,int> getPair(Point A){
            return make_pair(A.x,A.y);
        }
        int getSlope(Point A,Point B,double& resx, double &resy){
            	if(A.x == B.x){resx = (double)(A.x);resy=(double)(A.x); return 2;}
            	else {resx = (A.y-B.y)/(double)(A.x-B.x); resy=A.y-A.x*resx;return 1;}
        }

        int getUnique(vector<Point>&data,map<pair<int,int>,int>&result){
            int nMax = 0;
            for(size_t i=0;i!=data.size();++i){
                nMax = max(++result[make_pair(data[i].x,data[i].y)],nMax);
            }
            return nMax;
        }

 */
public class MaxPointsonaLine {
}
