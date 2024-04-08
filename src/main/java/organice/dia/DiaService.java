package organice.dia;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.NonNull;

@Service
public class DiaService {
    
    @Autowired
    private AccountRepository accountRepository;

    public Dia create(Dia in) {
        return NULL;
    }


}
