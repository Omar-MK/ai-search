public class Maps1
{
	static int[][] map1 = new int [][] {
    	{0, 5, 5, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
       	{5, 0, 5, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
       	{5, 5, 0, 5, 5, 10, 10, 10, 10, 5, 10, 5, 10, 10, 10 },
       	{10, 10, 5, 2, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
       	{10, 10, 5, 10, 0, 5, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
       	{10, 10, 10, 10, 5, 0, 5, 5, 10, 10, 10, 10, 10, 10, 10 },
       	{10, 10, 10, 10, 10, 5, 0, 10, 10, 10, 5, 10, 10, 10, 10 },
       	{10, 10, 10, 10, 10, 5, 10, 0, 5, 5, 5, 10, 10, 10, 10 },
       	{10, 10, 10, 10, 10, 10, 10, 5, 0, 5, 10, 10, 10, 10, 10 },
       	{10, 10, 5, 10, 10, 10, 10, 5, 5, 0, 10, 5, 5, 10, 10 },
       	{10, 10, 10, 10, 10, 10, 5, 5, 10, 10, 0, 10, 10, 5, 10 },
       	{10, 10, 5, 10, 10, 10, 10, 10, 10, 5, 10, 0, 10, 10, 5 },
       	{10, 10, 10, 10, 10, 10, 10, 10, 10, 5, 10, 10, 0, 5, 10 },
       	{10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 5, 10, 5, 8, 10 },
       	{10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 5, 10, 10, 0 }
    };

	static int[][] map2 = new int [][] {
		{0, 5, 5, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
		{5, 0, 5, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
		{5, 5, 0, 5, 5, 10, 10, 10, 10, 5, 10, 5, 10, 10, 10},
		{10, 10, 5, 2, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
		{10, 10, 5, 10, 0, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
		{10, 10, 10, 10, 10, 8, 5, 5, 10, 10, 10, 10, 10, 10, 10},
		{10, 10, 10, 10, 10, 5, 0, 10, 10, 10, 5, 10, 10, 10, 10},
		{10, 10, 10, 10, 10, 5, 10, 0, 5, 5, 5, 10, 10, 10, 10},
		{10, 10, 10, 10, 10, 10, 10, 5, 0, 5, 10, 10, 10, 10, 10},
		{10, 10, 5, 10, 10, 10, 10, 5, 5, 0, 10, 5, 5, 10, 10},
		{10, 10, 10, 10, 10, 10, 5, 5, 10, 10, 0, 10, 10, 5, 10},
		{10, 10, 5, 10, 10, 10, 10, 10, 10, 5, 10, 0, 10, 10, 5},
		{10, 10, 10, 10, 10, 10, 10, 10, 10, 5, 10, 10, 0, 5, 10},
		{10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 5, 10, 5, 0, 10},
		{10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 5, 10, 10, 0}
    };

	static int[][] map3 = new int [][] {
		{0, 5, 5, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
		{5, 0, 5, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
		{5, 5, 0, 5, 5, 10, 10, 10, 10, 5, 10, 5, 10, 10, 10},
		{10, 10, 5, 2, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
		{10, 10, 5, 10, 0, 5, 10, 10, 10, 10, 10, 10, 10, 10, 10},
		{10, 10, 10, 10, 5, 0, 5, 5, 10, 10, 10, 10, 10, 10, 10},
		{10, 10, 10, 10, 10, 5, 0, 10, 10, 10, 5, 10, 10, 10, 10},
		{10, 10, 10, 10, 10, 5, 10, 0, 5, 5, 5, 10, 10, 10, 10},
		{10, 10, 10, 10, 10, 10, 10, 5, 0, 5, 10, 10, 10, 10, 10},
		{10, 10, 5, 10, 10, 10, 10, 5, 5, 0, 10, 5, 5, 10, 10},
		{10, 10, 10, 10, 10, 10, 5, 5, 10, 10, 0, 10, 10, 5, 10},
		{10, 10, 5, 10, 10, 10, 10, 10, 10, 5, 10, 0, 10, 10, 10},
		{10, 10, 10, 10, 10, 10, 10, 10, 10, 5, 10, 10, 0, 5, 10},
		{10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 5, 10, 5, 0, 10},
		{10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 8}
    };

	static int[][] map4 = new int [][] {
		{2, 5, 5, 10, 10, 5, 10, 10, 10, 10, 10, 10, 10, 10, 10},
		{5, 0, 5, 10, 5, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
		{5, 5, 0, 5, 5, 10, 10, 10, 5, 5, 10, 5, 10, 10, 10},
		{10, 10, 5, 0, 10, 10, 10, 10, 10, 10, 10, 5, 10, 10, 5},
		{10, 5, 5, 10, 0, 5, 10, 5, 10, 10, 10, 10, 10, 10, 10},
		{5, 10, 10, 10, 5, 0, 5, 5, 10, 10, 10, 10, 10, 10, 10},
		{10, 10, 10, 10, 10, 5, 0, 10, 10, 10, 5, 10, 10, 10, 10},
		{10, 10, 10, 10, 5, 5, 10, 0, 5, 5, 5, 10, 10, 10, 10},
		{10, 10, 5, 10, 10, 10, 10, 5, 0, 5, 10, 5, 10, 5, 10},
		{10, 10, 5, 10, 10, 10, 10, 5, 5, 0, 10, 5, 5, 10, 10},
		{10, 10, 10, 10, 10, 10, 5, 5, 10, 10, 0, 10, 10, 5, 10},
		{10, 10, 5, 5, 10, 10, 10, 10, 5, 5, 10, 0, 10, 10, 10},
		{10, 10, 10, 10, 10, 10, 10, 10, 10, 5, 10, 10, 8, 5, 5},
		{10, 10, 10, 10, 10, 10, 10, 10, 5, 10, 5, 10, 5, 0, 5},
		{10, 10, 10, 5, 10, 10, 10, 10, 10, 10, 10, 10, 5, 5, 0}
    };

	static int[][] map5 = new int [][] {
		{0, 5, 5, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
		{5, 0, 5, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
		{5, 5, 0, 5, 5, 10, 10, 10, 10, 10, 10, 5, 10, 10, 10},
		{10, 10, 5, 2, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
		{10, 10, 5, 10, 0, 5, 10, 10, 10, 10, 10, 10, 10, 10, 10},
		{10, 10, 10, 10, 5, 0, 5, 5, 10, 10, 10, 10, 10, 10, 10},
		{10, 10, 10, 10, 10, 5, 0, 10, 10, 10, 10, 10, 10, 10, 10},
		{10, 10, 10, 10, 10, 5, 10, 0, 5, 10, 5, 10, 10, 10, 10},
		{10, 10, 10, 10, 10, 10, 10, 5, 0, 5, 10, 10, 10, 10, 10},
		{10, 10, 10, 10, 10, 10, 10, 10, 5, 0, 10, 10, 5, 10, 10},
		{10, 10, 10, 10, 10, 10, 10, 5, 10, 10, 0, 10, 10, 5, 10},
		{10, 10, 5, 10, 10, 10, 10, 10, 10, 10, 10, 0, 10, 10, 5},
		{10, 10, 10, 10, 10, 10, 10, 10, 10, 5, 10, 10, 0, 5, 10},
		{10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 5, 10, 5, 8, 10},
		{10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 5, 10, 10, 0}
    };

	static int[][] map6 = new int [][] {
		{2, 5, 10, 10, 5, 10, 10},
		{5, 0, 5, 10, 10, 10, 10},
		{10, 5, 0, 5, 10, 10, 10},
		{10, 10, 5, 8, 10, 10, 5},
		{5, 10, 10, 10, 0, 5, 10},
		{10, 10, 10, 10, 5, 0, 5},
		{10, 10, 10, 5, 10, 5, 0}
	};

	static int[][] map7 = new int [][] {
		{0, 5, 10, 10, 10, 10, 10},
		{5, 0, 5, 10, 10, 10, 10},
		{10, 5, 2, 5, 10, 10, 10},
		{10, 10, 5, 0, 10, 10, 5},
		{10, 10, 10, 10, 8, 10, 10},
		{10, 10, 10, 10, 10, 0, 5},
		{10, 10, 10, 5, 10, 5, 0}
    };

	static int[][] map8 = new int [][] {
		{0, 5, 10, 10, 5, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
		{5, 8, 5, 10, 10, 5, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
		{10, 5, 0, 5, 10, 10, 5, 10, 10, 10, 10, 10, 10, 10, 10, 10},
		{10, 10, 5, 0, 10, 10, 10, 5, 10, 10, 10, 10, 10, 10, 10, 10},
		{5, 10, 10, 10, 0, 5, 10, 10, 5, 10, 10, 10, 10, 10, 10, 10},
		{10, 5, 10, 10, 5, 0, 5, 10, 10, 5, 10, 10, 10, 10, 10, 10},
		{10, 10, 5, 10, 10, 5, 0, 5, 10, 10, 5, 10, 10, 10, 10, 10},
		{10, 10, 10, 5, 10, 10, 5, 0, 10, 10, 10, 5, 10, 10, 10, 10},
		{10, 10, 10, 10, 5, 10, 10, 10, 0, 5, 10, 10, 5, 10, 10, 10},
		{10, 10, 10, 10, 10, 5, 10, 10, 5, 0, 5, 10, 10, 5, 10, 10},
		{10, 10, 10, 10, 10, 10, 5, 10, 10, 5, 0, 5, 10, 10, 5, 10},
		{10, 10, 10, 10, 10, 10, 10, 5, 10, 10, 5, 0, 10, 10, 10, 5},
		{10, 10, 10, 10, 10, 10, 10, 10, 5, 10, 10, 10, 0, 5, 10, 10},
		{10, 10, 10, 10, 10, 10, 10, 10, 10, 5, 10, 10, 5, 0, 5, 10},
		{10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 5, 10, 10, 5, 2, 5},
		{10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 5, 10, 10, 5, 0}
    };

	static int[][] map9 = new int [][] {
		{0, 5, 10, 10, 5, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
		{5, 0, 5, 10, 10, 5, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
		{10, 5, 0, 5, 10, 10, 5, 10, 10, 10, 10, 10, 10, 10, 10, 10},
		{10, 10, 5, 0, 10, 10, 10, 5, 10, 10, 10, 10, 10, 10, 10, 10},
		{5, 10, 10, 10, 0, 5, 10, 10, 5, 10, 10, 10, 10, 10, 10, 10},
		{10, 5, 10, 10, 5, 0, 10, 10, 10, 5, 10, 10, 10, 10, 10, 10},
		{10, 10, 5, 10, 10, 10, 0, 5, 10, 10, 5, 10, 10, 10, 10, 10},
		{10, 10, 10, 5, 10, 10, 5, 2, 10, 10, 10, 5, 10, 10, 10, 10},
		{10, 10, 10, 10, 5, 10, 10, 10, 0, 5, 10, 10, 5, 10, 10, 10},
		{10, 10, 10, 10, 10, 5, 10, 10, 5, 8, 10, 10, 10, 10, 10, 10},
		{10, 10, 10, 10, 10, 10, 5, 10, 10, 10, 0, 5, 10, 10, 5, 10},
		{10, 10, 10, 10, 10, 10, 10, 5, 10, 10, 5, 0, 10, 10, 10, 5},
		{10, 10, 10, 10, 10, 10, 10, 10, 5, 10, 10, 10, 0, 5, 10, 10},
		{10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 5, 0, 5, 10},
		{10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 5, 10, 10, 5, 0, 5},
		{10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 5, 10, 10, 5, 0}
    };

	static int[][][] mapColl =
		{map1, map2, map3, map4, map5, map6, map7, map8, map9};
}
