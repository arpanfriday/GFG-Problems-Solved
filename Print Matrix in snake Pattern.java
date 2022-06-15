class Solution
{
    //Function to return list of integers visited in snake pattern in matrix.
    static ArrayList<Integer> snakePattern(int matrix[][])
    {
        // code here 
        boolean alt = true;
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0; i < matrix.length; i++) {
            if(alt) {
                for(int j = 0; j < matrix[i].length; j++) {
                    res.add(matrix[i][j]);
                }
                alt = false;
                continue;
            }
            for(int j = matrix[i].length-1; j >= 0; j--) {
                res.add(matrix[i][j]);
            }
            alt = true;
        }
        return res;
    }
}
