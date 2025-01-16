class Pair
{
    int w; 
    int h; 
    public Pair(int w, int h)
    {
        this.w = w; 
        this.h = h;  
    }
}

class PairSort implements Comparator<Pair>
{
    public int compare(Pair a, Pair b)
    {
        if(a.w == b.w)
            return a.h - b.h; 
        return b.w - a.w; 
    }
}
class Solution {
    public int findJustSmaller(List<Integer> res, int x)
    {
        int l = 0, r = res.size()-1; 
        int result = 0; 
        while(r >= l)
        {
            int mid = (r + l)/2; 
            if(res.get(mid) <= x)
            {
                result = mid; 
                r = mid-1; 
            }
            else
                l = mid+1; 
        }
        return result; 
    }
    public int maxEnvelopes(int[][] envelopes) {
        List<Pair> pairs = new ArrayList<Pair>(); 

        int n = envelopes.length; 
        for(int i = 0; i < n; i++)
        {
            pairs.add(new Pair(envelopes[i][0], envelopes[i][1])); 
        }

        Collections.sort(pairs, new PairSort()); 

        int[] dp = new int[n]; 
        List<Integer> res = new ArrayList<Integer>(); 
        for(int i = 0; i < n; i++)
        {
            if(res.size() == 0 || res.get(res.size()-1) > pairs.get(i).h)
                res.add(pairs.get(i).h); 
            else
            {
                int ind = findJustSmaller(res, pairs.get(i).h); 
                res.set(ind, pairs.get(i).h);
            }
        }
        return res.size(); 
    }
}
