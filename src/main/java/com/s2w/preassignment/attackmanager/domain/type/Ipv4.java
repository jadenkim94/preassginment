package com.s2w.preassignment.attackmanager.domain.type;

import com.s2w.preassignment.attackmanager.exception.ApplicationException;
import com.s2w.preassignment.attackmanager.exception.ErrorType;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.validator.routines.InetAddressValidator;

@Embeddable
@NoArgsConstructor
@Getter
public class Ipv4 {
    private String ip;

    private Ipv4(String ip) {
        this.ip = ip;
    }

    public static Ipv4 createIpv4(String ip) {
        InetAddressValidator validator = InetAddressValidator.getInstance();
        if (validator.isValidInet4Address(ip)) {
            return new Ipv4(ip);
        }
        throw new ApplicationException(ErrorType.INVALID_IP_ADDRESS);
    }
}
