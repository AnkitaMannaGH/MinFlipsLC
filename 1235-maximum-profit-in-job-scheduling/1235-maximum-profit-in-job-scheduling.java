class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
   var jobs = getSortedJobs(startTime, endTime, profit);
   var startTimes = getStartTimes(jobs);
   return jobScheduling(jobs, startTimes, 0, new HashMap<>());
}

private int[][] getSortedJobs(int[] startTime, int[] endTime, int[] profit) {
   var jobs = new int[startTime.length][3];
   for (var i = 0; i < startTime.length; i++)
   	jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
   Arrays.sort(jobs, Comparator.comparingInt(job -> job[0]));
   return jobs;
}

private int[] getStartTimes(int[][] jobs) {
   var startTimes = new int[jobs.length];
   for (int i = 0; i < jobs.length; i++)
   	startTimes[i] = jobs[i][0];
   return startTimes;
}

private int jobScheduling(int[][] jobs, int[] startTimes, int jobIndex, Map<Integer, Integer> profitByJob) {
   if (jobIndex == -1 || jobIndex == jobs.length)
   	return 0;
   if (profitByJob.containsKey(jobIndex))
   	return profitByJob.get(jobIndex);

   var nextJobIndex = getNextJobIndex(startTimes, jobs[jobIndex][1]);
   var profitIfScheduled = jobs[jobIndex][2] + jobScheduling(jobs, startTimes, nextJobIndex, profitByJob);
   var profitIfNotScheduled = jobScheduling(jobs, startTimes, jobIndex + 1, profitByJob);
   var profit = Math.max(profitIfScheduled, profitIfNotScheduled);

   profitByJob.put(jobIndex, profit);
   return profit;
}

private int getNextJobIndex(int[] startTimes, int lastEndingTime) {
   var low = 0;
   var high = startTimes.length - 1;
   var nextIndex = startTimes.length;

   while (low <= high) {
   	var mid = (low + high) / 2;
   	if (startTimes[mid] >= lastEndingTime) {
   		nextIndex = mid; // trying to find the best match
   		high = mid - 1;
   	} else {
   		low = mid + 1;
   	}
   }
   return nextIndex;
}
}