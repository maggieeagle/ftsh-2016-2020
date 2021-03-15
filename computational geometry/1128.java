import java.util.Scanner;

public class G {

	public static double a, b, c;

	/*
	 * public static double dist(double point_x, double point_y, double p1_x, double
	 * p1_y, double p2_x, double p2_y) {
	 * 
	 * double perp_x = (b * (b * point_x - a * point_y) - a * c) / (a * a + b * b);
	 * double perp_y = (a * (a * point_y - b * point_x) - b * c) / (a * a + b * b);
	 * 
	 * System.out.println(perp_x + " " + perp_y);
	 * 
	 * double dist;
	 * 
	 * //??????? double scalar = (p1_x - point_x)*(p2_x - point_x) + (p1_y -
	 * point_y)*(p2_y - point_y);
	 * 
	 * System.out.println("scalar = " + scalar);
	 * 
	 * if (a * perp_x + b * perp_y + c == 0 && scalar <= 0) { dist =
	 * Math.sqrt((point_x - perp_x) * (point_x - perp_x) + (point_y - perp_y) *
	 * (point_y - perp_y)); } else { double dist1 = Math.sqrt((point_x - p1_x) *
	 * (point_x - p1_x) + (point_y - p1_y) * (point_y - p1_y)); double dist2 =
	 * Math.sqrt((point_x - p2_x) * (point_x - p2_x) + (point_y - p2_y) * (point_y -
	 * p2_y)); dist = Math.min(dist1, dist2); }
	 * 
	 * //System.out.println(dist);
	 * 
	 * return dist; }
	 */

	public static double dist(double x0, double y0, double x1, double y1, double x2, double y2) {
		
		double x1_new = x1 - x0;
		double y1_new = y1 - y0;
		double x2_new = x2 - x0;
		double y2_new = y2 - y0;
		
		double a = y2_new - y1_new;
		double b = x1_new - x2_new;
		double c = x1_new * y2_new - x2_new * y1_new;
		
		double l = c / Math.sqrt(a * a + b * b);

		
		double x0_new = x0 - x1;
		double y0_new = y0 - y1;
		x2_new = x2 - x1;
		y2_new = y2 - y1;

		double scalar1 = x2_new * x0_new + y2_new * y0_new;

		x0_new = x0 - x2;
		y0_new = y0 - y2;
		x1_new = x1 - x2;
		y1_new = y1 - y2;

		double scalar2 = x1_new * x0_new + y1_new * y0_new;

		double dist;
		if(scalar1 >= 0 && scalar2 >= 0) dist = l;
		else dist = Math.sqrt(Math.min((x0-x1)*(x0-x1) + (y0-y1)*(y0-y1),
				(x0-x2)*(x0-x2) + (y0-y2)*(y0-y2)));
		
		return Math.abs(dist);
	}

	public static double angle(double p1_x, double p1_y, double p2_x, double p2_y, double p3_x, double p3_y) {
		double scalar = (p1_x - p2_x)*(p3_x - p2_x) + (p1_y - p2_y)*(p3_y - p2_y);
		double a = Math.sqrt((p1_x - p2_x)*(p1_x - p2_x) + (p1_y - p2_y)*(p1_y - p2_y));
		double b = Math.sqrt((p3_x - p2_x)*(p3_x - p2_x) + (p3_y - p2_y)*(p3_y - p2_y));
		double cos = scalar/(a*b);
		return Math.toDegrees(Math.acos(cos));
	}
	
	public static double arc_length(double r, double p1_x, double p1_y, double p2_x, double p2_y, double p3_x, double p3_y) {
		double angle = angle(p1_x, p1_y, p2_x, p2_y, p3_x, p3_y);
		double l = Math.PI*r*angle/180;
		return l;
	}
	
	public static double length(double x1, double y1, double x2, double y2) {
		return Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		double x_bear = sc.nextDouble(); // bears home
		double y_bear = sc.nextDouble();
		double x_rabbit = sc.nextDouble(); // rabbits home
		double y_rabbit = sc.nextDouble();

		double x_center = sc.nextDouble(); // center of the hole
		double y_center = sc.nextDouble();
		double r = sc.nextDouble();

		// line between homes
		a = y_rabbit - y_bear;
		b = x_bear - x_rabbit;
		c = x_bear * (y_bear - y_rabbit) + y_bear * (x_rabbit - x_bear);

		//System.out.println(a + "x + " + b + "y + " + c);

		double dist = dist(x_center, y_center, x_bear, y_bear, x_rabbit, y_rabbit);
		
		//System.out.println(dist);
		
		if(dist >= r) {
			double l = Math.sqrt((x_bear - x_rabbit)*(x_bear - x_rabbit) + (y_bear - y_rabbit)*(y_bear - y_rabbit));
			System.out.println(l);
		}
		else {
			//first tangent line from bears house
			double tmp_y = y_center - y_bear;
			double tmp_x = x_center - x_bear;
			double b1 = (r*tmp_y + Math.sqrt(r*r*tmp_y*tmp_y
					- (tmp_x*tmp_x + tmp_y*tmp_y)*(r*r - tmp_x*tmp_x)))/(tmp_x*tmp_x + tmp_y*tmp_y);
			double a1 = (r-b1*tmp_y)/tmp_x;
			double c1 = -a1*x_bear - b1*y_bear;
			
			//System.out.println(a1 + "x + " + b1 + "y + " + c1);
			
			//first point
			double first_touch_point_x = (b1 * (b1 * x_center - a1 * y_center) - a1 * c1) / (a1 * a1 + b1 * b1);
			double first_touch_point_y = (a1 * (a1 * y_center - b1 * x_center) - b1 * c1) / (a1 * a1 + b1 * b1);
			
			//System.out.println(first_touch_point_x + " " + first_touch_point_y);
			
			//second tangent line from bears house
			double b2 = (r*tmp_y - Math.sqrt(r*r*tmp_y*tmp_y
					- (tmp_x*tmp_x + tmp_y*tmp_y)*(r*r - tmp_x*tmp_x)))/(tmp_x*tmp_x + tmp_y*tmp_y);
			double a2 = (r-b2*tmp_y)/tmp_x;
			double c2 = -a2*x_bear - b2*y_bear;
			
			//System.out.println(a2 + "x + " + b2 + "y + " + c2);
			
			//second point
			double second_touch_point_x = (b2 * (b2 * x_center - a2 * y_center) - a2 * c2) / (a2 * a2 + b2 * b2);
			double second_touch_point_y = (a2 * (a2 * y_center - b2 * x_center) - b2 * c2) / (a2 * a2 + b2 * b2);
			
			//System.out.println(second_touch_point_x + " " + second_touch_point_y);
			
			
			//first tangent line from rabbits house
			tmp_y = y_center - y_rabbit;
			tmp_x = x_center - x_rabbit;
			b1 = (r*tmp_y + Math.sqrt(r*r*tmp_y*tmp_y
					- (tmp_x*tmp_x + tmp_y*tmp_y)*(r*r - tmp_x*tmp_x)))/(tmp_x*tmp_x + tmp_y*tmp_y);
			a1 = (r-b1*tmp_y)/tmp_x;
			c1 = -a1*x_rabbit - b1*y_rabbit;
			
			//System.out.println(a1 + "x + " + b1 + "y + " + c1);
			
			//third point
			double third_touch_point_x = (b1 * (b1 * x_center - a1 * y_center) - a1 * c1) / (a1 * a1 + b1 * b1);
			double third_touch_point_y = (a1 * (a1 * y_center - b1 * x_center) - b1 * c1) / (a1 * a1 + b1 * b1);
			
			//System.out.println(third_touch_point_x + " " + third_touch_point_y);
			
			//second tangent line from rabbits house
			b2 = (r*tmp_y - Math.sqrt(r*r*tmp_y*tmp_y
					- (tmp_x*tmp_x + tmp_y*tmp_y)*(r*r - tmp_x*tmp_x)))/(tmp_x*tmp_x + tmp_y*tmp_y);
			a2 = (r-b2*tmp_y)/tmp_x;
			c2 = -a2*x_rabbit - b2*y_rabbit;
			
			//System.out.println(a2 + "x + " + b2 + "y + " + c2);
			
			//fourth point
			double fourth_touch_point_x = (b2 * (b2 * x_center - a2 * y_center) - a2 * c2) / (a2 * a2 + b2 * b2);
			double fourth_touch_point_y = (a2 * (a2 * y_center - b2 * x_center) - b2 * c2) / (a2 * a2 + b2 * b2);
			
			//System.out.println(fourth_touch_point_x + " " + fourth_touch_point_y);
			
			//-------------------------------------------------------------------
			
			double length_1 = length(first_touch_point_x, first_touch_point_y, x_bear, y_bear);
			double length_2 = length(second_touch_point_x, second_touch_point_y, x_bear, y_bear);
			double length_3 = length(third_touch_point_x, third_touch_point_y, x_rabbit, y_rabbit);
			double length_4 = length(fourth_touch_point_x, fourth_touch_point_y, x_rabbit, y_rabbit);
			
			double arc_13 = arc_length(r, first_touch_point_x, first_touch_point_y,
					x_center, y_center, third_touch_point_x, third_touch_point_y);
			double arc_14 = arc_length(r, first_touch_point_x, first_touch_point_y,
					x_center, y_center, fourth_touch_point_x, fourth_touch_point_y);
			double arc_23 = arc_length(r, second_touch_point_x, second_touch_point_y,
					x_center, y_center, third_touch_point_x, third_touch_point_y);
			double arc_24 = arc_length(r, second_touch_point_x, second_touch_point_y,
					x_center, y_center, fourth_touch_point_x, fourth_touch_point_y);
			
			//System.out.println(length_1 + " " + length_2 + " " + length_3 + " " + length_4);
			//System.out.println(angle(first_touch_point_x, first_touch_point_y,
					//x_center, y_center, third_touch_point_x, third_touch_point_y));
		
			//System.out.println(arc_length(r, first_touch_point_x, first_touch_point_y,
					//x_center, y_center, third_touch_point_x, third_touch_point_y));
		
			double first_way = length_1 + arc_13 + length_3;
			double second_way = length_1 + arc_14 + length_4;
			double third_way = length_2 + arc_23 + length_3;
			double fourth_way = length_2 + arc_24 + length_4;
			
			double way = Math.min(first_way, Math.min(second_way, Math.min(third_way, fourth_way)));
			System.out.println(way);
		}

	}

}
