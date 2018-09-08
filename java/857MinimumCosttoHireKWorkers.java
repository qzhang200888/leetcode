class Solution {
    class QualityWage {
        public int quality;
        public int wage;
        public QualityWage(int quality, int wage) {
            this.quality = quality;
            this.wage = wage;
        }
        
        public double ratio() {
            return ((double) wage) / quality;
        }
    }
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        QualityWage[] lst = new QualityWage[quality.length];
        for (int i = 0; i < quality.length; ++i) {
            lst[i] = new QualityWage(quality[i], wage[i]);
        }
        
        Arrays.sort(lst, new Comparator<QualityWage>() {
            @Override
            public int compare(QualityWage qw1, QualityWage qw2) {
                return Double.compare(qw1.ratio(), qw2.ratio());
            }
        });
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        int sum = 0;
        double res = Double.MAX_VALUE;
        for (QualityWage qw: lst) {
            pq.offer(qw.quality);
            sum += qw.quality;
            if (pq.size() > K) {
                sum -= pq.poll();
            }
            if (pq.size() == K) {
                res = Math.min(res, sum * qw.ratio());
            }
        }
        
        return res;
    }
}
