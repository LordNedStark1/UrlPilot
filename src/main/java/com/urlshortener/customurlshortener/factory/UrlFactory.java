package com.urlshortener.customurlshortener.factory;

import com.urlshortener.customurlshortener.Utils.AppUtils;
import com.urlshortener.customurlshortener.model.Url;
import com.urlshortener.customurlshortener.repositorie.UrlRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;
import java.util.Random;
@Component
public class UrlFactory {
    @Autowired
    private UrlRepositories urlRepositories;
    private static final String companyLink = "http://tinyurls.at/";
    private static Character [] capitalLetters = AppUtils.getCapitalLetters();
    private static Character [] smallLetters = AppUtils.getSmallLetters();
    private static final Random random = new Random();


    public String shortenUrl() {
        String generatedUrl = null;
        boolean isNotGenerated = true;
        do {
            generatedUrl = generateShortUrl();
            Optional<Url> foundUrl = urlRepositories.findUrlByUrlReplacementLink(generatedUrl);
            if(foundUrl.isEmpty()) isNotGenerated = false;
        }while(isNotGenerated);

        return  generatedUrl;
    }

    private String generateShortUrl() {
        String shortUrl = companyLink + generateRandomString();

        return shortUrl;
    }
    private String generateRandomString() {
        StringBuilder randomString = new StringBuilder();

        randomString
                    .append(smallLetters[randomIndexGenerator()])
                    .append(smallLetters[randomIndexGenerator()])
                    .append(capitalLetters[randomIndexGenerator()])
                    .append(capitalLetters[randomIndexGenerator()]);
        return randomString.toString();
    }

    private int randomIndexGenerator() {

        return random.nextInt(26);
    }
    private int randomLengthGenerator(){
        int length = 3 + random.nextInt(4);
        return length;
    }




}


