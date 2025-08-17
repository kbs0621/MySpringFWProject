package mylab.notification.di.annot.config;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import mylab.notification.di.annot.EmailNotificationService;
import mylab.notification.di.annot.SmsNotificationService;
import mylab.notification.di.annot.NotificationManager;

@SpringJUnitConfig(classes = NotificationConfig.class)   // Spring Context 로드
public class NotificationConfigTest {

    @Autowired
    private NotificationManager notificationManager;

    @Test
    void testNotificationManagerNotNull() {
        assertNotNull(notificationManager, "NotificationManager should not be null");
    }

    @Test
    void testEmailServiceInjection() {
        EmailNotificationService emailService = notificationManager.getEmailService();
        assertNotNull(emailService, "EmailService should not be null");
        assertEquals("smtp.gmail.com", emailService.getSmtpServer(), "SMTP Server should match");
        assertEquals(587, emailService.getPort(), "Port number should match");
    }

    @Test
    void testSmsServiceInjection() {
        SmsNotificationService smsService = notificationManager.getSmsService();
        assertNotNull(smsService, "SmsService should not be null");
        assertEquals("SKT", smsService.getProvider(), "Provider should match");
    }

    @Test
    void testNotificationMethods() {
        notificationManager.sendNotificationByEmail("테스트 이메일");
        notificationManager.sendNotificationBySms("테스트 SMS");
    }
}