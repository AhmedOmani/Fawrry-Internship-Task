package model;

import java.time.LocalDate;

public class ExpirationInfo {
    
    private LocalDate expirationDate ;
 
    public ExpirationInfo(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }
    
    public boolean isExpired() {
        return this.expirationDate.isBefore(LocalDate.now());
    }

    public LocalDate getExpirationDate() {
        return this.expirationDate;
    }
}
