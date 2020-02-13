
/** To find number of combinations to pay amount of money in cents
    add types of coins one by one.

    1st use only 1c
    2nd use only 1c and 5c
    3rd use only 1c, 5c and 10c
    4th use 1c, 5c, 10c and 25c
  */
public int combinations(int n) {
    if (n < 0)
        return 0;

    int[] arr = new inty[n + 1];

    // first only use 1c coins. So any amount has 1 combination
    // amount 0 use no coins. I think it's a combination too
    for (int i = 0; i <= n; ++i)
        arr[i] = 1;

    // Then add 5c coins. Calculate the number of combinations
    // each iteration for j adds one 5c coins
    for (int i = n; i - 5 >= 0; --i) {
    {
        for (j = i - 5; j >= 0; j -= 5)
            arr[i] += arr[j];
    }

    // Then add 10c coins. Calculate the number of combinations
    // each iteration for j adds one 10c coins
    for (int i = n; i - 10 >= 0; --i) {
    {   
        for (j = i - 10; j >= 0; j -= 10)
            arr[i] += arr[j];
    }

    // Then add 10c coins. Calculate the number of combinations
    // each iteration for j adds one 10c coins
    for (int i = n; i - 25 >= 0; --i) {
    {
        for (j = i - 25; j >= 0; j -= 25)
            arr[i] += arr[j];
    }

    return arr[n];
}
