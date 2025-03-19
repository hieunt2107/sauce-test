import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    public static void main(String[] args) {
        // Tự động tải và thiết lập ChromeDriver
        WebDriverManager.chromedriver().setup();

        // Khởi tạo trình duyệt Chrome
        WebDriver driver = new ChromeDriver();

        // Mở trang Google
        driver.get("https://www.google.com");

        // In ra tiêu đề trang
        System.out.println("Title: " + driver.getTitle());

        // Đóng trình duyệt
        driver.quit();
    }
}
