package Week5;

import java.util.*;

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class EfficientClosestPair {
    /* 
    Dalam closest pair dengan divide & conquer, maka points harus diurutkan
    terlebih dahulu. Misalkan kompleksitas untuk sorting ini adalah O(n log n) dengan
    merge sort. Kemudian, strip yang ditemukan juga harus diurutkan lagi dengan
    kompleksitas O(n log n).Dengan demikian, closest pair dengan divide & conquer 
    mempunyai kompleksitas 0{n (log n)^2))
    
    Sedangkan closest Pair dengan brute force mempunyai kompleksitas 
    O(n^2) karena memerlukan dua buah loop. Apabila point yang dibandingkan
    semakin banyak, maka akan semakin lama juga waktu yang dibutuhkan untuk
    mencarinya
    
    Dengan demikian, closest pair dengan divide & conquer jauh lebih kecil 
    kompleksitasnya jika dibandingkan dengan metode brute force
    */
    
    
    //Sort points
    static double closestPair(Point[] points) {
        int n = points.length;
        Point[] xSorted = new Point[n];
        Point[] ySorted = new Point[n];

        for (int i = 0; i < n; i++) {
            xSorted[i] = points[i];
            ySorted[i] = points[i];
        }
        Arrays.sort(xSorted, (p1, p2) -> p1.x - p2.x);
        Arrays.sort(ySorted, (p1, p2) -> p1.y - p2.y);

        return efficienClosestPair(xSorted, ySorted, 0, n - 1);
    }

    static double efficienClosestPair(Point[] px, Point[] py, int low, int high) {
        //Menentukan jumlah points yang sedang dihitung
        int n = high - low + 1;

        //Jika jumlahnya kurang dari 4, gunakan brute force
        if (n <= 3) {
            return closestPairUsingBruteForce(px);
        }

        //Mementukan titik tengah untuk menjadi titik pembagian
        int mid = low + (high - low) / 2;
        Point midPoint = px[mid];

        //Mencari titik terkecil dari bagian kiri dan kanan dari mid
        double leftMin = efficienClosestPair(px, py, low, mid);
        double rightMin = efficienClosestPair(px, py, mid + 1, high);

        //Mencari jarak terkecil dari bagian kiri dan kanan
        double minDistance = Math.min(leftMin, rightMin);

        //Mencari jarak terdekat apabila pointnya terdapat satu point dari left dan right
        //dengan mencari strip
        int stripLeft = -1;
        int stripRight = -1;

        for (int i = low; i < high; i++) {
            if (Math.abs(py[i].x - midPoint.x) < minDistance) {
                if (stripLeft == -1) {
                    stripLeft = i;
                } else {
                    stripRight = i;
                }
            }
        }
        double minFromStrip = getMinStripeDistance(py, stripLeft, stripRight);
        return min(minDistance, minFromStrip);
    }

    //Mencari closest pair dengan bruteforce
    static double closestPairUsingBruteForce(Point[] points) {
        double min = Double.MAX_VALUE;

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                double dist = distance(points[i], points[j]);
                if (dist < min) {
                    min = dist;
                }
                min = min(min, dist);
            }
        }
        return min;
    }

    static double getMinStripeDistance(Point[] ySorted, int low, int high) {
        double min = Double.MAX_VALUE;

        for (int i = low; i <= high; i++) {
            for (int j = i + 1; j <= high; j++) {
                min = min(min, distance(ySorted[i], ySorted[j]));
            }
        }
        return min;
    }

    //Menghitung jarak antara dua titik
    static double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }

    //Menentukan jarak mana yang lebih kecil
    static double min(double val1, double val2) {
        return Math.min(val1, val2);
    }

    public static void main(String args[]) {
        int[] x = {3, 5, 9, 12};
        int[] y = {4, 12, 12, 16};

        int n = x.length;
        Point[] points = new Point[n];

        for (int i = 0; i < n; i++) {
            points[i] = new Point(x[i], y[i]);
        }

        double distance = closestPair(points);

        System.out.println(distance);
    }
}
