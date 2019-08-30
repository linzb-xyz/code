import java.util.*;

public class pdd {
    public static void main(String[] args) {
        fun1();
//        fun2();
//        fun3();
//        fun4();
//        fun5();
//        fun6();
    }

    public static void fun1() {
        ArrayList<Integer> arr1 = new ArrayList() ;
        ArrayList<Integer> arr2 = new ArrayList() ;
        Scanner in = new Scanner(System.in);
        String line1 = in.nextLine();
        Scanner in2 = new Scanner(line1);
        while(in2.hasNextInt()){
            arr1.add(in2.nextInt());
        }
        String line2 = in.nextLine();
        Scanner in3 = new Scanner(line2);
        while(in3.hasNextInt()){
            arr2.add(in3.nextInt());
        }
        if(arr1.size() <= 1){
            System.out.println(arr1.get(0));
            return ;
        }
        int lessless = arr1.get(0), less = arr1.get(0), more = arr1.get(0), middle =arr1.get(0);

        int lesslesspos = 0, lesspos = 0, morepos =0, middlepos=0;
        for(int i = 1; i < arr1.size(); i++){
            if(middle < arr1.get(i)){
                middle = arr1.get(i);
                continue;
            }else{

                less = middle;
                lesspos = i-1;
                middle = arr1.get(i);
                middlepos = i;
                if(i+1 < arr1.size()){
                    more = arr1.get(i+1);
                    morepos = i+1;
                }

            }

        }

        Collections.sort(arr2);

        boolean flag = false;
        for(int i = arr2.size()-1; i >= 0; i--){
            if(more != arr1.get(0) && middle < arr2.get(i) && more > arr2.get(i)){
                arr1.set(middlepos, arr2.get(i));
                flag = true;
                break;
            }
        }
        if(!flag){
            for(int i = arr2.size()-1; i >= 0; i--){
                if( middle > arr2.get(0) && less < arr2.get(i)){
                    arr1.set(lesspos, arr2.get(i));
                    flag = true;
                    break;
                }
            }
        }

        if(flag){
            for (int i = 0; i < arr1.size(); i++) {
                System.out.print(arr1.get(i));
            }
            System.out.println();
        }else {
            System.out.println("NO");
        }
    }

    public static void fun2() {

    }
/*
5 6
1 2 1 1 1
1 2
1 3
1 4
2 5
3 5
4 5
 */
    public static class Job {
        int id;
        int time;

        public Job(int id, int time) {
            this.id = id;
            this.time = time;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Job job = (Job) o;
            return id == job.id &&
                    time == job.time;
        }

        @Override
        public int hashCode() {

            return Objects.hash(id, time);
        }
    }

    public static void fun3() {
        HashMap<Integer,List<Integer>> map = new HashMap<>();


        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();

        int[] Pi = new int[N];
        Job[] jobs = new Job[N];

        PriorityQueue<Job> priorityQueue = new PriorityQueue<>(N, new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                return o1.time == o2.time ? o1.id - o2.id : o1.time - o2.time;
            }
        });

        for(int i = 0 ;i < N;i++) {
            Pi[i] = in.nextInt();
            jobs[i] = new Job(i+1, Pi[i]);
            map.put(i+1, new ArrayList<Integer>());
        }


        int[][] Yi = new int[M][2];
        for(int i = 0 ;i < M;i++) {
            Yi[i][0] = in.nextInt();
            Yi[i][1] = in.nextInt();

            List<Integer> l = map.get(Yi[i][1]);
            l.add(Yi[i][0]);
        }

        Iterator it = map.keySet().iterator();
        while(it.hasNext()){

            // 获取key
            int key = (int)it.next();
            // 获取value
            List<Integer> value = (List<Integer>) map.get(key);
            if(value.size()==0) {
                priorityQueue.add(jobs[key-1]);
                it.remove();
            }
        }

        int cur = 0;
        int[] finishId = new int[N];
        while(!priorityQueue.isEmpty()){
//            System.out.println("size:"+priorityQueue.size());
            Job job = priorityQueue.poll();
            finishId[cur] = job.id;
            for(int i = 0; i < M; i++){
                if(Yi[i][0] == job.id){
                    map.get(Yi[i][1]).remove((Integer)job.id);
                }
            }

            Iterator it2 = map.keySet().iterator();
            while(it2.hasNext()){
                // 获取key
                int key = (int)it2.next();
                // 获取value
                List<Integer> value = (List<Integer>) map.get(key);
                if(value.size()==0) {
                    priorityQueue.add(jobs[key-1]);
                    it2.remove();
                }
            }
            cur++;
        }

        for(int i = 0; i <finishId.length; i++ ){
            System.out.print(finishId[i]+" ");
        }
        System.out.println();

    }
}
