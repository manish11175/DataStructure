package questions;

public class RainTrap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int height[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		rainTrap(height);

	}

	public static void rainTrap(int height[]) {
		int lmax[] = new int[height.length];
		int rmax[] = new int[height.length];
		lmax[0] = height[0];
		for (int i = 1; i < height.length; i++) {
			lmax[i] = Math.max(lmax[i - 1], height[i]);
		}
		rmax[height.length - 1] = height[height.length - 1];
		for (int i = height.length - 2; i >= 0; i--) {
			rmax[i] = Math.max(rmax[i + 1], height[i]);

		}

		int ans = 0;
		for (int i = 0; i < height.length; i++) {
			int minwall = Math.min(lmax[i], rmax[i]);
			if (minwall > height[i]) {
				ans += minwall - height[i];
			}
		}
		System.out.println(ans);
	}
}
