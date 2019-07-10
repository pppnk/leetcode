//We have a list of points on the plane. Find the K closest points to the origin (0, 0). 
//
// (Here, the distance between two points on a plane is the Euclidean distance.) 
//
// You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in.) 
//
// 
//
// 
// Example 1: 
//
// 
//Input: points = [[1,3],[-2,2]], K = 1
//Output: [[-2,2]]
//Explanation: 
//The distance between (1, 3) and the origin is sqrt(10).
//The distance between (-2, 2) and the origin is sqrt(8).
//Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
//We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
// 
//
// 
// Example 2: 
//
// 
//Input: points = [[3,3],[5,-1],[-2,4]], K = 2
//Output: [[3,3],[-2,4]]
//(The answer [[-2,4],[3,3]] would also be accepted.)
// 
//
// 
//
// Note: 
//
// 
// 1 <= K <= points.length <= 10000 
// -10000 < points[i][0] < 10000 
// -10000 < points[i][1] < 10000 
// 
// 
//

class Solution {
    public int[][] kClosest(int[][] points, int K) {
        Point[] distances = new Point[points.length];
        for(int i = 0; i < points.length; i++){
            distances[i] = new Point(points[i][0], points[i][1]);
        }
        sortKElements(distances, 0, distances.length - 1, K);
        for(int i = 0; i < K; i++){
            points[i][0] = distances[i].x;
            points[i][1] = distances[i].y;
        }
        return Arrays.copyOfRange(points, 0, K);
    }

    public void sortKElements(Point[] distances, int start, int end, int k){
        if(start <= end) {
            int middle = partition(distances, start, end);
            if (middle < k) {
                sortKElements(distances, middle + 1, end, k);
            } else {
                sortKElements(distances, start, middle - 1, k);
            }
        }
    }

    public int partition(Point[] distances, int start, int end){
        double pivot = distances[end].distance;
        int pointer = start;
        for(int i = start; i < end; i++){
            if(distances[i].distance < pivot){
                swap(distances, i, pointer);
                pointer++;
            }
        }
        swap(distances, pointer, end);
        return pointer;
    }

    public void swap(Point[] distance, int x, int y){
        Point temp = distance[x];
        distance[x] = distance[y];
        distance[y] = temp;
    }
}

class Point{
    int x, y;
    double distance;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
        this.distance = x * x + y * y;
    }
}