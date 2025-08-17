package mylab.notification.di.annot;

public class NotificationManager {
    private NotificationService emailService;
    private NotificationService smsService;

    public NotificationManager(NotificationService emailService, NotificationService smsService) {
        this.emailService = emailService;
        this.smsService = smsService;
    }

    // 구체 클래스 반환으로 변경
    public EmailNotificationService getEmailService() {
        return (EmailNotificationService) emailService;
    }

    public SmsNotificationService getSmsService() {
        return (SmsNotificationService) smsService;
    }

    public void sendNotificationByEmail(String message) {
        emailService.sendNotification(message);
    }

    public void sendNotificationBySms(String message) {
        smsService.sendNotification(message);
    }
}