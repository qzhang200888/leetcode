public class MovingAverage {
    int size;
    LinkedList<Integer> lst;
    long sum;
    int count;
    /*
    * @param size: An integer
    */public MovingAverage(int size) {
        // do intialization if necessary
        lst = new LinkedList<>();
        this.size = size;
        sum = 0;
        count = 0;
    }

    /*
     * @param val: An integer
     * @return:  
     */
    public double next(int val) {
        // write your code here
        sum += val;
        ++count;
        lst.add(val);
        if (count > size) {
            int v = lst.get(0);
            sum -= v;
            --count;
            lst.removeFirst();
        }

        return (double)sum / count;
    }
}
