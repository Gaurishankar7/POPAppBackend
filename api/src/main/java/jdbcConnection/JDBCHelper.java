package jdbcConnection;

/**
 * 
 * 
 * @description JDBCHelper class having all the sql queries to be used in api's.
 *
 */

public class JDBCHelper {

	/**
	 * @
	 */

	public static final String selectRestaurant = "SELECT * FROM restaurant";
	public static final String selectRestaurantById = "select * from restaurant where restaurant_id =?";
	public static final String insertRestaurant = "INSERT INTO restaurant (restaurant_name, restaurant_area, restaurant_image,restaurant_cuisine,restaurant_phoneno) VALUES(?,?,?,?,?)";
	public static final String deleteRestaurantById = "delete from restaurant where restaurant_id =?";
	public static final String updateRestaurant = "update restaurant set restaurant_name=? where restaurant_id=?";

	public static final String selectRestaurantMenu = "SELECT * FROM menu_items";
	public static final String selectRestaurantMenuById = "select * from menu_items where restaurant_id =? and category_id=?";
	public static final String insertMenuItems = "INSERT INTO menu_items(restaurant_id, category_id, menu_item_name, price, menu_image, availability_status) VALUES(?,?,?,?,?,?)";

	public static final String deleteMenuItem = "delete * from menu_items where menu_id=?";

	public static final String insertOrder = "INSERT INTO orderdetails (order_id,restaurant_id, dishno, order_quantity, total_price, payment_status) VALUES(?,?,?,?,?,?)";
	public static final String selectOrder = "SELECT * FROM orderdetails";

	public static final String selectUserId = "select user_id,login_status from login_details where user_emailid=? and and device_token=?";

	// order_id
	// Service App Queries...
//restaurant_rating
	public static final String selectCurrentOrderId = "SELECT order_id from orders where user_id=? order by order_id desc limit 1";
	public static final String updateRestaurantRating = "UPDATE restaurant SET restaurant_rating =(SELECT ROUND(AVG(order_rating)))from orders where restaurant_id=?";
	// chef
	public static final String selectChef = "select * from chef_details";
	public static final String selectChefById = "select * from chef_details where restaurant_id =?";
	public static final String insertChef = "INSERT INTO chef_details (restaurant_id, chef_name, chef_gender,chef_mobile,chef_image) VALUES(?,?,?,?,?)";
	public static final String updateChef = "UPDATE chef_details SET restaurant_id =?, chef_name=?,chef_gender=?,chef_mobile =?,chef_image=? WHERE chef_id =?";
	public static final String deleteChefById = "delete from chef_details where chef_id =?";
	public static final String checkInsert = "SELECT chef_id FROM chef_details ORDER BY chef_id desc LIMIT 1";
	public static final String checkUpdate = "SELECT chef_id FROM chef_details where chef_id=?";
//orders
	public static final String updateChefIdInOrder = "UPDATE orders SET order_start_time =?, chef_id = ? WHERE order_id = ?";
	public static final String selectorderlist = "SELECT items.menu_list,items.price,items.menu_image,orders.order_id,orders.dishno,orders.order_quantity,orders.total_price, orders.restaurant_id FROM menuitems items INNER JOIN orderdetails orders ON items.listno =orders.dishno where orders.dishno =?";

	public static final String insertInToOderDetail = "insert into order_detail(order_id, menu_id, quantity, price)select ?,?,?,price from menu_items where menu_id=?";
	public static final String insertInToOrder = "INSERT INTO orders (order_id,user_id, restaurant_id,order_start_time,total_price,order_status,payment_status,stripe_response_id) VALUES (?,?,?,?,?,?,?,?)";

	public static final String selectPriceFromMenuItems = "SELECT price from menu_items where menu_id=?";

	public static final String selectOrderId = "select order_id,order_status from orders where order_id=?";

	public static final String sumPrice = "select sum(price) from order_detail where order_id=?";

	

	public static final String updateOrderRating = "update orders set order_rating=? where order_id=?";

	public static final String updateOrderStatus = "update orders set order_status=? where order_id=?";

	public static final String updateMenuItemStatus = "update menu_items set availability_status=? where menu_id=?";

	public static final String selectMenuItemName = "select menu_item_name from menu_item where menu=? ";

	public static final String selectOrderSummary = "select r.restaurant_name,r.restaurant_area,r.restaurant_image,r.restaurant_phoneno,m.menu_id,m.menu_item_name,m.price, o.order_id,o.total_price,o.order_status,od.quantity from menu_items m INNER JOIN order_detail od on m.menu_id=od.menu_id INNER Join orders o on o.order_id=od.order_id INNER join restaurant r on r.restaurant_id= o.restaurant_id where o.order_id=?";

	// Login App Chef Queries...
	public static final String fetchLoginCredentials = "SELECT * FROM login_details";
	public static final String insertLoginCredentials = "INSERT INTO login_details (user_emailid, device_token, user_name,user_role,login_status) VALUES(?,?,?,?,?) ";

	// Service User Login Check.....

	public static final String selectUserAndPaassword = "select user_id,restaurant_id from login_details where user_name=? and user_password=? ";
	public static final String selectOrderDetailsOfSpecificRestaurant = "select  o.order_id, l.user_name,m.menu_item_name,od.quantity,( select chef_name from chef_details c where c.chef_id = o.chef_id ) as chef_name,o.order_start_time,o.order_status from menu_items m INNER JOIN order_detail od on m.menu_id=od.menu_id INNER Join orders o on o.order_id=od.order_id inner join login_details l on l.user_id=o.user_id where o.restaurant_id=? and o.order_id in (SELECT order_id from orders where restaurant_id=?)order by order_id desc";
	// "select m.menu_item_name,m.price,od.quantity,( select chef_name from
	// chef_details c where c.chef_id = o.chef_id ) as
	// chef_name,o.order_start_time,o.order_status from menu_items m INNER JOIN
	// order_detail od on m.menu_id=od.menu_id INNER Join orders o on
	// o.order_id=od.order_id inner join login_details l on l.user_id=o.user_id
	// where o.order_id=?";
//		;
	public static final String updateServiceUserDeviceToken = "UPDATE login_details SET device_token =? WHERE user_id=?";
	public static final String selectOrderIds = "select l.user_name , o.order_id from orders o inner join login_details l on o.user_id= l.user_id where o.restaurant_id=? order by order_id desc";

	//host	
	public static final String selectOrderList = "select o.order_id,l.user_name,o.order_status,o.total_price from orders o inner join login_details l on o.user_id=l.user_id where o.restaurant_id=?";
	public static final String orderSummaryByOrderId = "select o.order_id, l.user_name,m.menu_item_name,od.quantity,( select chef_name from chef_details c where c.chef_id = o.chef_id ) as chef_name,o.order_start_time,o.order_status from menu_items m INNER JOIN order_detail od on m.menu_id=od.menu_id INNER Join orders o on o.order_id=od.order_id inner join login_details l on l.user_id=o.user_id where o.order_id =?";
	
	

}