import java.time.LocalDateTime;

import java.time.LocalDateTime;

    public class Purchase {

        private LocalDateTime subscriptionsDate;

        private String courseName;

        private String studentName;

        private int price;

        public Purchase (LocalDateTime subscriptionsDate, String courseName) {
            this.subscriptionsDate = subscriptionsDate;
            this.courseName = courseName;
        }

        public void setSubscriptionsDate(LocalDateTime subscriptionsDate) {

        }

        public LocalDateTime getSubscriptionsDate() {
            return subscriptionsDate;
        }
        @Override
        public String toString() {
            return "" + subscriptionsDate;
        }

    }
