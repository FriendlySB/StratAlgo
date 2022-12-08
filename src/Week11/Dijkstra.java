package Week11;

public class Dijkstra {
    
    /*
    1121018 - Friendly Sejati Bunardi
    
    Shortest path between two nodes
      
    Algorithm ShortestPath(graph[[0...n-1],[0...n-1]], start)
        count <- n
        for i <- 0 to count do 
            visitedVertex[i] <- false
            distance[i] <- infinity //Atau angka yang sebesar mungkin
    
        //Jarak dari vertex start ke dirinya sendiri pasti 0
        distance[start] <- 0
    
        for i <- 0 to count do
            //Cari vertex dengan jarak terkeci
            u <- minDistance(distance,visitedVertex)
            visitedVertex[u] <- true 
            for v <- 0 to count do 
                //Assign distance pada v jika distance pada u + graph [u][v] lebih kecil
                //dari distance pada v dan vertex tersebut belum pernah dikunjungi
                if !visitedVertex[v] and graph[u][v] != 0 and distance[u] + graph[u][v] < distance[v]
                    distance[v] = distance[u] + graph[u][v]
        return distance
        //Array distance berisi jarak dari vertex start ke sebuah vertex lain
    
    Algorithm minDistance(distance[0...n-1], visitedVertex[0...n-1]
        minDistance <- infinity //Atau angka yang sebesar mungkin
        minDistanceVertex <- -1
        for i <- 0 to n do 
            if !visitedVertex[i] && distance[i] < minDistance
                minDistance = distance[i];
                minDistanceVertex = i;
        return minDistanceVertex;
    
    Analisis
    
    Algortima getShortestPathDijkstra diatas mempunyai time complexity O(n^2) dimana
    algoritma tersebut membutuhkan dua loop untuk menghitung jarak antar dua
    vertex, mencatat vertex yang sudah dikunjungi, dan menghitung jarak terkecil
    antara dua vertex dengan fungsi minDistance
    
    Algortima dari fungsi minDistance mempunyai time complexity O(n) dimana
    algoritma tersebut membutuhkan satu loop untuk membandingkan jarak antara
    vertex
    
    Dengan demikian, time complexity secara keseluruhan untuk algoritma untuk
    mencari jarak terpendek antar dua vertex dalam graph adalah n^2 + n yang kemudian
    dapat direpresentasikan menjadi O(n^2) karena timpe complexity n^2 menutupi 
    time complexity n
    
    Sedangkan space complexity untuk algortima secara keseluruhan adalah O(n)
    dimana algortima getShortestPathDijkstra membutuhkan dua buah array dengan 
    panjang n untuk menampung vertex yang telah dikunjungi dan jarak antara
    vertex start dan vertex lainnya dalam graph
    */
    
    static int minDistance(int distance[],boolean visitedVertex[]){
        int minDistance = Integer.MAX_VALUE;
        int minDistanceVertex = -1;
        for (int i = 0; i < distance.length; i++) {
            if (!visitedVertex[i] && distance[i] < minDistance) {
                minDistance = distance[i];
                minDistanceVertex = i;
            }
        }
        return minDistanceVertex;
    }
    
    static int[] getShortestPathDijkstra(int graph[][], int start){
        int count = graph.length;
        boolean visitedVertex[] = new boolean[count];
        int distance[] = new int[count];
        for (int i = 0; i < count; i++) {
            visitedVertex[i] = false;
            distance[i] = Integer.MAX_VALUE;
        }
        distance[start] = 0;
        for (int i = 0; i < count; i++) {
            int u = minDistance(distance, visitedVertex);
            visitedVertex[u] = true;

            for (int v = 0; v < count; v++) {
                if (!visitedVertex[v] && graph[u][v] != 0 && (distance[u] + graph[u][v] < distance[v])) {
                    distance[v] = distance[u] + graph[u][v];
                }
            }
        }
        return distance;
    }
    
    static void start(){
        //Representasi bentuk graph dengan adjacency matrix
        int graph[][] = {
           //A  B  C  D  E  F  G  H
            {0, 1, 5, 0, 0, 0, 0, 0},//A
            {1, 0, 0, 3, 0, 0, 0, 0},//B
            {5, 0, 0, 2, 0, 0, 0, 0},//C
            {0, 3, 2, 0, 5, 4, 0, 0},//D
            {0, 0, 0, 5, 0, 0, 2, 0},//E
            {0, 0, 0, 4, 0, 0, 0, 3},//F
            {0, 0, 0, 0, 2, 0, 0, 1},//G
            {0, 0, 0, 0, 0, 3, 1, 0} //H
        };
        int start = 0; //A
        int tujuan = 7; //H
        int distance[] = getShortestPathDijkstra(graph, start);
        
        //Array huruf untuk diprint
        String huruf[] = {"A","B","C","D","E","F","G","H"};
        System.out.println("Jarak terpendek dari " + huruf[start] + 
                " ke " + huruf[tujuan] + " adalah " + distance[tujuan]);
        
    }
    
    public static void main(String args[]) {
        start();
    }
}
