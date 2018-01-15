import java.io.*;
import java.util.*;
public class rectangle {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    int n = Integer.parseInt(br.readLine());
    State[] list = new State[n];
    TreeSet<Integer> ys = new TreeSet<Integer>();
    for(int a = 0; a < n; a++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      list[a] = new State(x, y, st.nextToken().equals("H"));
      ys.add(y);
    }
    Arrays.sort(list);
    ArrayList<Integer> ysArray = new ArrayList<Integer>();
    for(int y: ys) {
      ysArray.add(y);
    }
    int most = 0;
    int area = 0;
    for(int i = 0; i < ysArray.size(); i++) {
      for(int j = i+1; j < ysArray.size(); j++) {
        boolean valid = false;
        int lastX = -1;
        int cur = 0;
        for(int a = 0; a < n;) {
          int b = a;
          int red = 0;
          int blue = 0;
          while(b < n && list[a].x == list[b].x) {
            if(list[b].y >= ysArray.get(i) && list[b].y <= ysArray.get(j)) {
              if(list[b].red) {
                red++;
              }
              else {
                blue++;
              }
            }
            b++;
          }
          if(blue > 0) {
            valid = false;
            cur  = 0;
          }
          else if(red + blue > 0) {
            if(!valid) {
              valid = true;
              lastX = list[a].x;
            }
            cur += red;
            int currArea = (ysArray.get(j) - ysArray.get(i)) * (list[a].x - lastX);
            if(cur > most || (cur == most && currArea < area)) {
              most = cur;
              area = currArea;
            }
          }
          a = b;
        }
      }
    }
    pw.println(most);
    pw.println(area);
    pw.close();
  }
  static class State implements Comparable<State> {
    public int x,y;
    public boolean red;
    public State(int a, int b, boolean c) {
      x=a;
      y=b;
      red=c;
    }
    public int compareTo(State s) {
      return x - s.x;
    }
  }
}