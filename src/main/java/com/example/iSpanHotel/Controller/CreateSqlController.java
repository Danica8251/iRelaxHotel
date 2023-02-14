package com.example.iSpanHotel.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.iSpanHotel.Class.BCrypt;
import com.example.iSpanHotel.Class.DateUtils;
import com.example.iSpanHotel.Class.JWTutils;
import com.example.iSpanHotel.Class.Weather;
import com.example.iSpanHotel.Dao.EmployeeDao;
import com.example.iSpanHotel.Dao.HotelNewsDao;
import com.example.iSpanHotel.Dao.ItemDao;
import com.example.iSpanHotel.Dao.MemberDao;
import com.example.iSpanHotel.Dao.OrderDao;
import com.example.iSpanHotel.Dao.OrderJournalDao;
import com.example.iSpanHotel.Dao.PermissionsDao;
import com.example.iSpanHotel.Dao.RoomDao;
import com.example.iSpanHotel.Dao.RoomTypeDao;
import com.example.iSpanHotel.model.Employee;
import com.example.iSpanHotel.model.HotelNews;
import com.example.iSpanHotel.model.Item;
import com.example.iSpanHotel.model.Member;
import com.example.iSpanHotel.model.Order;
import com.example.iSpanHotel.model.OrderJournal;
import com.example.iSpanHotel.model.Permissions;
import com.example.iSpanHotel.model.Room;
import com.example.iSpanHotel.model.RoomType;

import io.jsonwebtoken.Claims;

@RestController
@RequestMapping("/createSql")
public class CreateSqlController {
	List<RoomType> roomTypes = new ArrayList<>();
	RoomType roomType1 = new RoomType();
	RoomType roomType2 = new RoomType();
	RoomType roomType3 = new RoomType();
	RoomType roomType4 = new RoomType();
	RoomType roomType5 = new RoomType();
	RoomType roomType6 = new RoomType();
	RoomType roomType7 = new RoomType();
	RoomType roomType8 = new RoomType();
	RoomType roomType9 = new RoomType();
	
	@Autowired
	private PermissionsDao permissionsDao;
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private RoomTypeDao roomTypeDao;
	@Autowired
	private HotelNewsDao hotelNewsDao;
	@Autowired
	private RoomDao roomDao;
	@Autowired
	private EmployeeDao employeeDao;
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private OrderJournalDao orderJournalDao;
	@Autowired
	private ItemDao itemDao;
	
	@PostMapping("/createAll")
	private void createAll() {
		member();
		permissions();
		employee();
		roomType();
		room();
		hotelNews();
		order();
	}
	
	@PostMapping("/member")
	private void member() {
		Member member1 = new Member();
		member1.setAccount("nienfxxq@gmail.com");
		member1.setPasswd(BCrypt.hashpw("Eibaiyexoh9I", BCrypt.gensalt()));
		member1.setRealName("周杰倫");
//		member1.setEmail("nienfxxq@gmail.com");
		member1.setTel("0962275261");
		memberDao.save(member1);
		
		Member member2 = new Member();
		member2.setAccount("DamionCCraig@rhyta.com");
		member2.setPasswd(BCrypt.hashpw("aaqu6IMoh", BCrypt.gensalt()));
		member2.setRealName("周興哲");
//		member2.setEmail("DamionCCraig@rhyta.com");
		member2.setTel("0912439724");
		memberDao.save(member2);
		
		Member member3 = new Member();
		member3.setAccount("LatashaFHanley@armyspy.com");
		member3.setPasswd(BCrypt.hashpw("ahP6XahMoh", BCrypt.gensalt()));
		member3.setRealName("鄧紫棋");
//		member3.setEmail("LatashaFHanley@armyspy.com");
		member3.setTel("0939416211");
		memberDao.save(member3);
		
		Member member4 = new Member();
		member4.setAccount("AldenJPark@armyspy.com");
		member4.setPasswd(BCrypt.hashpw("aeyieloo2Ae", BCrypt.gensalt()));
		member4.setRealName("韋禮安");
//		member4.setEmail("AldenJPark@armyspy.com");
		member4.setTel("0939503316");
		memberDao.save(member4);
		
		Member member5 = new Member();
		member5.setAccount("StephenLChong@armyspy.com");
		member5.setPasswd(BCrypt.hashpw("iekohRah5oo", BCrypt.gensalt()));
		member5.setRealName("張惠妹");
//		member5.setEmail("StephenLChong@armyspy.com");
		member5.setTel("0953115883");
		memberDao.save(member5);
		
		Member member6 = new Member();
		member6.setAccount("DudleyMNordin@armyspy.com");
		member6.setPasswd(BCrypt.hashpw("Ieh8Ojein", BCrypt.gensalt()));
		member6.setRealName("梁靜茹");
//		member6.setEmail("DudleyMNordin@armyspy.com");
		member6.setTel("0928269591");
		memberDao.save(member6);
		
		Member member7 = new Member();
		member7.setAccount("RicardoJGilliam@armyspy.com");
		member7.setPasswd(BCrypt.hashpw("nee9esiuJ5e", BCrypt.gensalt()));
		member7.setRealName("蔡依林");
//		member7.setEmail("RicardoJGilliam@armyspy.com");
		member7.setTel("0921383622");
		memberDao.save(member7);
		
		Member member8 = new Member();
		member8.setAccount("HaroldJBilger@rhyta.com");
		member8.setPasswd(BCrypt.hashpw("ohDa3Vogho", BCrypt.gensalt()));
		member8.setRealName("徐佳瑩");
//		member8.setEmail("HaroldJBilger@rhyta.com");
		member8.setTel("0913852136");
		memberDao.save(member8);
		
		Member member9 = new Member();
		member9.setAccount("PatriciaSCooke@armyspy.com");
		member9.setPasswd(BCrypt.hashpw("pu0aiG5nei", BCrypt.gensalt()));
		member9.setRealName("林俊傑");
//		member9.setEmail("PatriciaSCooke@armyspy.com");
		member9.setTel("0912345678");
		memberDao.save(member9);
		
		Member member10 = new Member();
		member10.setAccount("HaroldEGibbs@armyspy.com");
		member10.setPasswd(BCrypt.hashpw("uo2ieThaena", BCrypt.gensalt()));
		member10.setRealName("陳奕迅");
//		member10.setEmail("HaroldEGibbs@armyspy.com");
		member10.setTel("0953243243");
		memberDao.save(member10);
	}
	
	@PostMapping("/roomType")
	private void roomType() {
		File file1 = new File("./roomImg/1.png");
		InputStream inputStream1;
		try {
			inputStream1 = new FileInputStream(file1);
			roomType1.setRoomPic(IOUtils.toByteArray(inputStream1));
		} catch (Exception e) {
			e.printStackTrace();
		}
		roomType1.setRoomType("經濟雙人房");
		roomType1.setRoomPrice(2500);
		roomType1.setRoomPerson(2);
//		roomType1.setRoomPic("https://images.pexels.com/photos/271639/pexels-photo-271639.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
		roomType1.setContent("房間面積為36平方米/383平方英尺。\r\n"
				+ "\r\n"
				+ "調高設計和超大窗戶使得房間充滿柔和的自然光線。\r\n"
				+ "\r\n"
				+ "大理石浴室配備純平電視、浴缸及獨立的玻璃淋浴間。");
		roomTypes.add(roomType1);
		roomTypeDao.save(roomType1);
		
		File file2 = new File("./roomImg/2.png");
		InputStream inputStream2;
		try {
			inputStream2 = new FileInputStream(file2);
			roomType2.setRoomPic(IOUtils.toByteArray(inputStream2));
		} catch (Exception e) {
			e.printStackTrace();
		}
		roomType2.setRoomType("經濟四人房");
		roomType2.setRoomPrice(4500);
		roomType2.setRoomPerson(4);
//		roomType2.setRoomPic("https://images.pexels.com/photos/271624/pexels-photo-271624.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
		roomType2.setContent("房間面積為60平方米/646平方英尺。\r\n"
				+ "\r\n"
				+ "調高設計和超大窗戶使得房間充滿柔和的自然光線。\r\n"
				+ "\r\n"
				+ "大理石浴室配備純平電視、浴缸及獨立的玻璃淋浴間。");
		roomTypes.add(roomType2);
		roomTypeDao.save(roomType2);
		
		File file3 = new File("./roomImg/3.png");
		InputStream inputStream3;
		try {
			inputStream3 = new FileInputStream(file3);
			roomType3.setRoomPic(IOUtils.toByteArray(inputStream3));
		} catch (Exception e) {
			e.printStackTrace();
		}
		roomType3.setRoomType("景觀雙人房");
		roomType3.setRoomPrice(3000);
		roomType3.setRoomPerson(2);
//		roomType3.setRoomPic("https://images.pexels.com/photos/271618/pexels-photo-271618.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
		roomType3.setContent("房間面積為40平方米/349平方英尺。\r\n"
				+ "\r\n"
				+ "可飽覽壯麗的臺北101景觀或城市風光。\r\n"
				+ "\r\n"
				+ "寬敞的起居室配備沙發。\r\n"
				+ "\r\n"
				+ "大理石浴室配備純平電視、浴缸及獨立的玻璃淋浴間。\r\n"
				+ "\r\n"
				+ "獨立的玻璃淋浴間");
		roomTypes.add(roomType3);
		roomTypeDao.save(roomType3);
		
		File file4 = new File("./roomImg/4.png");
		InputStream inputStream4;
		try {
			inputStream4 = new FileInputStream(file4);
			roomType4.setRoomPic(IOUtils.toByteArray(inputStream4));
		} catch (Exception e) {
			e.printStackTrace();
		}
		roomType4.setRoomType("景觀四人房");
		roomType4.setRoomPrice(5500);
		roomType4.setRoomPerson(4);
//		roomType4.setRoomPic("https://images.pexels.com/photos/279746/pexels-photo-279746.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
		roomType4.setContent("房間面積為60平方米/646平方英尺。\r\n"
				+ "\r\n"
				+ "可飽覽壯麗的臺北101景觀或城市風光。\r\n"
				+ "\r\n"
				+ "寬敞的起居室配備沙發。\r\n"
				+ "\r\n"
				+ "大理石浴室配備純平電視、浴缸及獨立的玻璃淋浴間。\r\n"
				+ "\r\n"
				+ "獨立的玻璃淋浴間");
		roomTypes.add(roomType4);
		roomTypeDao.save(roomType4);
		
		File file5 = new File("./roomImg/5.png");
		InputStream inputStream5;
		try {
			inputStream5 = new FileInputStream(file5);
			roomType5.setRoomPic(IOUtils.toByteArray(inputStream5));
		} catch (Exception e) {
			e.printStackTrace();
		}
		roomType5.setRoomType("豪華雙人房");
		roomType5.setRoomPrice(3500);
		roomType5.setRoomPerson(2);
//		roomType5.setRoomPic("https://images.pexels.com/photos/1743229/pexels-photo-1743229.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
		roomType5.setContent("飽覽迷人的城市景觀。\r\n"
				+ "\r\n"
				+ "享受無線上網服務。\r\n"
				+ "\r\n"
				+ "房間面積為40平方米/349平方英尺。\r\n"
				+ "\r\n"
				+ "寬敞起居室配備沙發和躺椅。\r\n"
				+ "\r\n"
				+ "大理石浴室配備純平電視、浴缸及獨立的玻璃淋浴間。\r\n"
				+ "\r\n"
				+ "獨立淋浴間\r\n"
				+ "\r\n"
				+ "調高設計和超大窗戶使得房間充滿柔和的自然光線。\r\n"
				+ "\r\n"
				+ "大理石浴室配備純平電視、浴缸及獨立的玻璃淋浴間。");
		roomTypes.add(roomType5);
		roomTypeDao.save(roomType5);
		
		File file6 = new File("./roomImg/6.png");
		InputStream inputStream6;
		try {
			inputStream6 = new FileInputStream(file6);
			roomType6.setRoomPic(IOUtils.toByteArray(inputStream6));
		} catch (Exception e) {
			e.printStackTrace();
		}
		roomType6.setRoomType("豪華四人房");
		roomType6.setRoomPrice(6500);
		roomType6.setRoomPerson(4);
//		roomType6.setRoomPic("https://images.pexels.com/photos/172872/pexels-photo-172872.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
		roomType6.setContent("飽覽迷人的城市景觀。\r\n"
				+ "\r\n"
				+ "享受無線上網服務。\r\n"
				+ "\r\n"
				+ "房間面積為56平方米/603平方英尺。\r\n"
				+ "\r\n"
				+ "寬敞起居室配備沙發和躺椅。\r\n"
				+ "\r\n"
				+ "大理石浴室配備純平電視、浴缸及獨立的玻璃淋浴間。\r\n"
				+ "\r\n"
				+ "獨立淋浴間\r\n"
				+ "\r\n"
				+ "調高設計和超大窗戶使得房間充滿柔和的自然光線。\r\n"
				+ "\r\n"
				+ "大理石浴室配備純平電視、浴缸及獨立的玻璃淋浴間。");
		roomTypes.add(roomType6);
		roomTypeDao.save(roomType6);
		
		File file7 = new File("./roomImg/7.png");
		InputStream inputStream7;
		try {
			inputStream7 = new FileInputStream(file7);
			roomType7.setRoomPic(IOUtils.toByteArray(inputStream7));
		} catch (Exception e) {
			e.printStackTrace();
		}
		roomType7.setRoomType("尊榮雙人房");
		roomType7.setRoomPrice(6000);
		roomType7.setRoomPerson(2);
//		roomType7.setRoomPic("https://images.pexels.com/photos/97083/pexels-photo-97083.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
		roomType7.setContent("房間面積為72平方米/802平方英尺。\r\n"
				+ "\r\n"
				+ "飽覽臺北市的迷人全景。\r\n"
				+ "\r\n"
				+ "豪華的單臥室套房配備起居室、就餐區和小型廚房。\r\n"
				+ "\r\n"
				+ "寬敞的大理石浴室配有12寸純平電視、浴缸和獨立淋浴間。\r\n"
				+ "\r\n"
				+ "可享受豪華閣貴賓廊專屬服務及禮遇。\r\n"
				+ "\r\n"
				+ "享受無線上網服務。");
		roomTypes.add(roomType7);
		roomTypeDao.save(roomType7);
		
		File file8 = new File("./roomImg/8.png");
		InputStream inputStream8;
		try {
			inputStream8 = new FileInputStream(file8);
			roomType8.setRoomPic(IOUtils.toByteArray(inputStream8));
		} catch (Exception e) {
			e.printStackTrace();
		}
		roomType8.setRoomType("尊榮四人房");
		roomType8.setRoomPrice(11000);
		roomType8.setRoomPerson(4);
//		roomType8.setRoomPic("https://images.pexels.com/photos/271672/pexels-photo-271672.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
		roomType8.setContent("房間面積為136平方米/1,463平方英尺。\r\n"
				+ "\r\n"
				+ "飽覽臺北市的迷人全景。\r\n"
				+ "\r\n"
				+ "豪華的單臥室套房配備起居室、就餐區和小型廚房。\r\n"
				+ "\r\n"
				+ "寬敞的大理石浴室配有12寸純平電視、浴缸和獨立淋浴間。\r\n"
				+ "\r\n"
				+ "可享受豪華閣貴賓廊專屬服務及禮遇。\r\n"
				+ "\r\n"
				+ "享受無線上網服務。");
		roomTypes.add(roomType8);
		roomTypeDao.save(roomType8);
		
		File file9 = new File("./roomImg/9.png");
		InputStream inputStream9;
		try {
			inputStream9 = new FileInputStream(file9);
			roomType9.setRoomPic(IOUtils.toByteArray(inputStream9));
		} catch (Exception e) {
			e.printStackTrace();
		}
		roomType9.setRoomType("總統套房");
		roomType9.setRoomPrice(20000);
		roomType9.setRoomPerson(4);
//		roomType9.setRoomPic("https://images.pexels.com/photos/271619/pexels-photo-271619.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
		roomType9.setContent("房間面積為226平方米/2,432平方英尺。\r\n"
				+ "\r\n"
				+ "寬敞飄窗可飽覽臺北美妙絕倫的都市風光。\r\n"
				+ "\r\n"
				+ "豪華的單臥室套房配備起居室、就餐區和小型廚房。\r\n"
				+ "\r\n"
				+ "寬敞的浴室配備桑拿房和按摩浴缸。 管家服務。\r\n"
				+ "\r\n"
				+ "可享受豪華閣貴賓廊專屬服務及禮遇。\r\n"
				+ "\r\n"
				+ "享受無線上網服務。\r\n"
				+ "\r\n"
				+ "可享受豪華閣貴賓廊專屬服務及禮遇。");
		roomTypes.add(roomType9);
		roomTypeDao.save(roomType9);
	}
	
	@PostMapping("/hotelNews")
	private void hotelNews() {
		HotelNews hotelNew1 = new HotelNews();
		File file1 = new File("./newsImg/1.png");
		InputStream inputStream1;
		try {
			inputStream1 = new FileInputStream(file1);
			hotelNew1.setPic(IOUtils.toByteArray(inputStream1));
		} catch (Exception e) {
			e.printStackTrace();
		}
		hotelNew1.setNewsType((short) 1);
		hotelNew1.setTitle("溫馨聖誕嘉年華");
		hotelNew1.setStartDate("2022-12-16");
		hotelNew1.setEndDate("2022-12-31");
//		hotelNew1.setPic("https://tpe.fareasternhotel.com.tw/upload/catalog_news_b/twL_catalog_news_22L02_LaBnO907N3.png");
		hotelNew1.setContent("誠摯地邀請您與我們共度溫馨聖誕及歡樂新年！<br>"
				+ "除了一系列豐富美食與慶祝活動外，在這美好的節日裡，歡迎您蒞臨"
				+ "飯店大廳感受充滿節慶氣氛的佈置以及繽紛童趣的旋轉木馬與聖誕市"
				+ "集，佳節期間亦特別設置了零錢捐款活動，您可選擇支持國際兒童村"
				+ "或新北市玩具銀行，和我們一起用實際行動傳遞愛與祝福，支持台灣"
				+ "需要幫助的團體！<br>"
				+ "趕快來一趟，共度溫馨聖誕及歡樂新年！<br>"
				+ "即日起至2023/01/03(二)<br>"
				+ "凡上傳您與大廳上聖誕布置的合照至Instagram，並完成以下步驟：<br>"
				+ "1.文中標記 #(帳號須公開)<br>"
				+ "2.追蹤官方Instagram帳號@即可抽「下午茶兩客」<br>"
				+ "我們將於2023/1/06(五)在臉書及Insagram公布幸運得獎者！");
		hotelNewsDao.save(hotelNew1);
		
		HotelNews hotelNew2 = new HotelNews();
		File file2 = new File("./newsImg/2.jpg");
		InputStream inputStream2;
		try {
			inputStream2 = new FileInputStream(file2);
			hotelNew2.setPic(IOUtils.toByteArray(inputStream2));
		} catch (Exception e) {
			e.printStackTrace();
		}
		hotelNew2.setNewsType((short) 2);
		hotelNew2.setTitle("奢旅漫遊 超值享受");
		hotelNew2.setStartDate("2023-01-01");
		hotelNew2.setEndDate("2023-01-10");
//		hotelNew2.setPic("https://tpe.fareasternhotel.com.tw/upload/catalog_news_b/twL_catalog_news_21J27_E9ttWiGHON.jpg");
		hotelNew2.setContent("放鬆身心的奢華五星假期，需要慢慢感受！入住兩晚以上豪華房型享"
				+ "7折優惠；經濟套房享6折優惠！<br>"
				+ "專案包含：<br>"
				+ "◆入住兩晚以上豪華房型享7折優惠；經濟套房享6折優惠<br>"
				+ "◆免費使用健身俱樂部及頂樓景觀恆溫泳池<br>"
				+ "◆含豪華禮遇，包含早餐、下午茶及雞尾酒時光<br>"
				+ "<br>"
				+ "條款及細則<br>"
				+ "1.房價需加收10%服務費及5%稅金。<br>"
				+ "2.敬請事先預訂，此優惠須視訂房時客房供應情況方可確認訂房。<br>"
				+ "3.此專案內容之優惠恕不得與其它優惠或政府旅遊補助併用。<br>"
				+ "4.飯店保留取消與修改專案優惠的權利。<br>"
				+ "5.不適用日期:2022/1/31-2/5<br>"
				+ "6.早餐、下午茶及雞尾酒時光場域需視當日住房率而定");
		hotelNewsDao.save(hotelNew2);
		
		HotelNews hotelNew3 = new HotelNews();
		File file3 = new File("./newsImg/3.jpg");
		InputStream inputStream3;
		try {
			inputStream3 = new FileInputStream(file3);
			hotelNew3.setPic(IOUtils.toByteArray(inputStream3));
		} catch (Exception e) {
			e.printStackTrace();
		}
		hotelNew3.setNewsType((short) 2);
		hotelNew3.setTitle("總是寵愛‧一生香愛-總統套房情人住房專案");
		hotelNew3.setStartDate("2023-02-04");
		hotelNew3.setEndDate("2023-03-14");
//		hotelNew3.setPic("https://tpe.fareasternhotel.com.tw/upload/catalog_news_b/twL_catalog_news_21J27_E9ttWiGHON.jpg");
		hotelNew3.setContent("用最特別的美食美酒美景奢華度假體驗，寵愛最特別的摯愛！<br>"
				+ "iRelax精心準備「總是寵愛‧一生香愛」情人住房專案，於飯店最高等級的總統套房"
				+ "打造奢華戀愛假期，盡享屬於兩人的甜蜜時光！從抵達浪漫花藝佈置的總統套房的那一"
				+ "刻起，迎賓巧克力與微醺香檳，已讓戀人沉醉在台北高樓城市美景裡。還可於70坪大器"
				+ "挑高的總統套房中甜蜜享用雙人晚餐，並有專人於現場演奏悠揚琴曲，您還可包場私人電"
				+ "影院，放閃與尊榮同時擁有！<br>"
				+ "<br>"
				+ "專案包含：<br>"
				+ "◆入住總統套房<br>"
				+ "◆豪華閣禮遇包含豐盛早餐、下午茶及晚間雞尾酒及點心<br>"
				+ "◆套房內情人花藝及汽球佈置<br>"
				+ "◆雙人客房餐飲消費抵用10,000元<br>"
				+ "◆精選香檳一瓶及迎賓巧克力一盒<br>"
				+ "◆套房內鋼琴現場演奏一小時<br>"
				+ "◆威秀電影雙人包場 (影片及場次需依威秀電影院檔期為主)，使用期限至2023年3月14日<br>"
				+ "◆免費使用健身房及頂樓景觀恆溫泳池<br>"
				+ "◆免費停車<br>"
				+ "<br>"
				+ "條款與細則<br>"
				+ "1.房價另加10%服務費和5%稅金<br>"
				+ "2.敬請事先訂房，如欲取消住房，需提前二日告知<br>"
				+ "3.此專案適用雙人入住<br>"
				+ "4.此專案內容之優惠恕不得與其它優惠併用<br>"
				+ "5.飯店保留取消與修改專案優惠的權利");
		
		hotelNewsDao.save(hotelNew3);
	}

	@PostMapping("/permissions")
	private void permissions() {
		Permissions permissions1 = new Permissions();
		permissions1.setPermission("member_manage");
		permissions1.setNote("會員管理");
		permissionsDao.save(permissions1);
		
		Permissions permissions2 = new Permissions();
		permissions2.setPermission("employee_manage");
		permissions2.setNote("員工管理");
		permissionsDao.save(permissions2);
		
		Permissions permissions3 = new Permissions();
		permissions3.setPermission("room_manage");
		permissions3.setNote("房間管理");
		permissionsDao.save(permissions3);
		
		Permissions permissions4 = new Permissions();
		permissions4.setPermission("roomtype_manage");
		permissions4.setNote("房型管理");
		permissionsDao.save(permissions4);
		
		Permissions permissions5 = new Permissions();
		permissions5.setPermission("news_manage");
		permissions5.setNote("消息管理");
		permissionsDao.save(permissions5);
		
		Permissions permissions6 = new Permissions();
		permissions6.setPermission("customer_service");
		permissions6.setNote("客服");
		permissionsDao.save(permissions6);
		
		Permissions permissions7 = new Permissions();
		permissions7.setPermission("manager");
		permissions7.setNote("管理者");
		permissionsDao.save(permissions7);
	}
	
	@PostMapping("/room")
	private void room() {
		for (int i = 11; i <= 20; i++) {
			if (i <=16) {
				Room room1 = new Room();
				room1.setRoomNum(i + "01");
				room1.setRoomFloor(i);
				room1.setRoomStatus((short)1);
				room1.setRoomType(roomType1);
				room1.setNote(null);
				roomDao.save(room1);
					
				Room room2 = new Room();
				room2.setRoomNum(i + "02");
				room2.setRoomFloor(i);
				room2.setRoomStatus((short)1);
				room2.setRoomType(roomType2);
				room2.setNote(null);
				roomDao.save(room2);
					
				Room room3 = new Room();
				room3.setRoomNum(i + "03");
				room3.setRoomFloor(i);
				room3.setRoomStatus((short)1);
				room3.setRoomType(roomType3);
				room3.setNote(null);
				roomDao.save(room3);
					
				Room room4 = new Room();
				room4.setRoomNum(i + "04");
				room4.setRoomFloor(i);
				room4.setRoomStatus((short)1);
				room4.setRoomType(roomType4);
				room4.setNote(null);
				roomDao.save(room4);
					
				Room room5 = new Room();
				room5.setRoomNum(i + "05");
				room5.setRoomFloor(i);
				room5.setRoomStatus((short)1);
				room5.setRoomType(roomType5);
				room5.setNote(null);
				roomDao.save(room5);
					
				Room room6 = new Room();
				room6.setRoomNum(i + "06");
				room6.setRoomFloor(i);
				room6.setRoomStatus((short)1);
				room6.setRoomType(roomType6);
				room6.setNote(null);
				roomDao.save(room6);
					
				Room room7 = new Room();
				room7.setRoomNum(i + "07");
				room7.setRoomFloor(i);
				room7.setRoomStatus((short)1);
				room7.setRoomType(roomType7);
				room7.setNote(null);
				roomDao.save(room7);
					
				Room room8 = new Room();
				room8.setRoomNum(i + "08");
				room8.setRoomFloor(i);
				room8.setRoomStatus((short)1);
				room8.setRoomType(roomType8);
				room8.setNote(null);
				roomDao.save(room8);
			}
			if (i > 16) {
				Room room9 = new Room();
				room9.setRoomNum(i + "VIP");
				room9.setRoomFloor(i);
				room9.setRoomStatus((short)1);
				room9.setRoomType(roomType9);
				room9.setNote(null);
				roomDao.save(room9);
			}
		}
		
	}

	@PostMapping("/employee")
	private void employee() {
		Employee employee1 = new Employee();

		Set<Long> id1 = new HashSet<>();
		id1.add((long)3);
		id1.add((long)4);
		Iterable<Long> ids1 = (Iterable<Long>)id1;

		employee1.setAccount("ispan001");
		employee1.setPasswd(BCrypt.hashpw("ispan001", BCrypt.gensalt()));
		employee1.setName("熊仔");
		employee1.setPermissions(permissionsDao.findAllById(ids1));
		employeeDao.save(employee1);
		
		Employee employee2 = new Employee();
		Set<Long> id2 = new HashSet<>();
		id2.add((long)2);
		id2.add((long)3);
		Iterable<Long> ids2 = (Iterable<Long>)id2;
		employee2.setAccount("ispan002");
		employee2.setPasswd(BCrypt.hashpw("ispan002", BCrypt.gensalt()));
		employee2.setName("瘦子");
		employee2.setPermissions(permissionsDao.findAllById(ids2));
		employeeDao.save(employee2);
		
		Employee employee3 = new Employee();
		Set<Long> id3 = new HashSet<>();
		id3.add((long)5);
		Iterable<Long> ids3 = (Iterable<Long>)id3;
		employee3.setAccount("ispan003");
		employee3.setPasswd(BCrypt.hashpw("ispan003", BCrypt.gensalt()));
		employee3.setName("小春");
		employee3.setPermissions(permissionsDao.findAllById(ids3));
		employeeDao.save(employee3);
		
		Employee employee4 = new Employee();
		Set<Long> id4 = new HashSet<>();
		id4.add((long)6);
		id4.add((long)7);
		Iterable<Long> ids4 = (Iterable<Long>)id4;
		employee4.setAccount("ispan004");
		employee4.setPasswd(BCrypt.hashpw("ispan004", BCrypt.gensalt()));
		employee4.setName("熱狗");
		employee4.setPermissions(permissionsDao.findAllById(ids4));
		employeeDao.save(employee4);
		
		Employee employee5 = new Employee();
		Set<Long> id5 = new HashSet<>();
		id5.add((long)1);
		Iterable<Long> ids5 = (Iterable<Long>)id5;
		employee5.setAccount("ispan005");
		employee5.setPasswd(BCrypt.hashpw("ispan005", BCrypt.gensalt()));
		employee5.setName("張震嶽");
		employee5.setPermissions(permissionsDao.findAllById(ids5));
		employeeDao.save(employee5);
	}
	
	@PostMapping("/order")
	private void order() {
		try {
			Order order1 = new Order();
			Item item1 = new Item();
			Member member1 = memberDao.findById((long)1).get();
			Room room1 = roomDao.findById((long)10).get();
			order1.setMember(member1);
			order1.setOrderDate(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2023-01-01 08:31:50"));
			item1.setCheckinDate(new SimpleDateFormat("yyyy-MM-dd").parse("2023-01-03"));
			item1.setCheckoutDate(new SimpleDateFormat("yyyy-MM-dd").parse("2023-01-05"));
			item1.setRoom(room1);
			item1.setOrder(order1);
			orderDao.save(order1);
			itemDao.save(item1);
			List<String> dates = DateUtils.getBetweenDates("2023-01-03", "2023-01-05", true);
			for (int i = 0; i < dates.size(); i++) {
				OrderJournal orderJournal = new OrderJournal();
				orderJournal.setMember(member1);
				orderJournal.setRoom(room1);
				orderJournal.setOrder(order1);
				orderJournal.setStayDate(new SimpleDateFormat("yyyy-MM-dd").parse(dates.get(i)));
				orderJournalDao.save(orderJournal);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		try {
			Order order2 = new Order();
			Item item2 = new Item();
			Member member2 = memberDao.findById((long)4).get();
			Room room2 = roomDao.findById((long)52).get();
			order2.setMember(member2);
			order2.setOrderDate(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2023-01-16 16:40:12"));
			item2.setCheckinDate(new SimpleDateFormat("yyyy-MM-dd").parse("2023-01-20"));
			item2.setCheckoutDate(new SimpleDateFormat("yyyy-MM-dd").parse("2023-01-25"));
			item2.setRoom(room2);
			item2.setOrder(order2);
			orderDao.save(order2);
			itemDao.save(item2);
			List<String> dates = DateUtils.getBetweenDates("2023-01-20", "2023-01-25", true);
			for (int i = 0; i < dates.size(); i++) {
				OrderJournal orderJournal = new OrderJournal();
				orderJournal.setMember(member2);
				orderJournal.setRoom(room2);
				orderJournal.setOrder(order2);
				orderJournal.setStayDate(new SimpleDateFormat("yyyy-MM-dd").parse(dates.get(i)));
				orderJournalDao.save(orderJournal);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		try {
			Order order3 = new Order();
			Item item3 = new Item();
			Member member3 = memberDao.findById((long)2).get();
			Room room3 = roomDao.findById((long)45).get();
			order3.setMember(member3);
			order3.setOrderDate(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2023-01-31 23:11:28"));
			item3.setCheckinDate(new SimpleDateFormat("yyyy-MM-dd").parse("2023-02-15"));
			item3.setCheckoutDate(new SimpleDateFormat("yyyy-MM-dd").parse("2023-02-18"));
			item3.setRoom(room3);
			item3.setOrder(order3);
			orderDao.save(order3);
			itemDao.save(item3);
			List<String> dates = DateUtils.getBetweenDates("2023-02-15", "2023-02-18", true);
			for (int i = 0; i < dates.size(); i++) {
				OrderJournal orderJournal = new OrderJournal();
				orderJournal.setMember(member3);
				orderJournal.setRoom(room3);
				orderJournal.setOrder(order3);
				orderJournal.setStayDate(new SimpleDateFormat("yyyy-MM-dd").parse(dates.get(i)));
				orderJournalDao.save(orderJournal);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
	
	@PostMapping("/testJWT")
	private void testJWT() {
		// 生成
		String token = JWTutils.creatJWT("測試", null);
		System.out.println("生成token=:" + token);
		// 解析
		try {
			Claims claims = JWTutils.parseJWT(token);
			System.out.println("解析成功" + claims.getSubject());
		} catch (Exception exception) {
			System.out.println("解析失敗:");
			exception.printStackTrace();
		}
	}
	
	@PostMapping("/weather")
	private void weather() {
		Weather.getWeather();
	}
	
}
