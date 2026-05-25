
class Solution {
    public int leastInterval(char[] tasks, int n) {

        int[] count = new int[26];

        for(char task : tasks)
        {
            count[task - 'A']++;
        }

        int max = 0;

        for(int num : count)
        {
            max = Math.max(max, num);
        }

        int maxCount = 0;

        for(int num : count)
        {
            if(num == max)
            {
                maxCount++;
            }
        }

        int partCount = max - 1;
        int partLength = n - (maxCount - 1);

        int emptySlots = partCount * partLength;

        int availableTasks = tasks.length - (max * maxCount);

        int idles = Math.max(0, emptySlots - availableTasks);

        return tasks.length + idles;
    }
}