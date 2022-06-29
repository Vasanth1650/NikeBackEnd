/**
 * AesEncyptor Is An Interface Which Implements AttributeConverter Which Contains convertToDatabaseColumn And
 * convertToEntityAttribute Method Which Converts The Entity Data According To The Attribute And Column
 * 
 * The Flow Of Data Will Be In The Form Of Secret Key And PlainText Are Converted Into Cipher And Stored As A 
 * Cipher Text Which Is In The Form Of 128bit/192bit/256bit
 * 
 * AesEncryption Vs DesEncryption Where Des Encryption Has More Data Flow Where The PlainText Will Be Passed
 * And It Undergoes Initial Permutation Which Is 32:32 Fixed Known Bit Permutation The Final Permutation Is The
 * Inverse Of The Initial Permutation And It Undergoes In between Permutation Is LPT And RPT Both Contains 16Key
 * And Then FinalPermutation And Then Only The Data Will Be Able To Recover.(56bit)
 * 
 * And RSA
 * 
 * Key - Base64
 * */

package com.example.demo.dao;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.SerializationUtils;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.persistence.AttributeConverter;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.util.Base64;

@Configuration
public class AesEncryptor implements AttributeConverter<Object, String> {

    @Value("${aes.encryption.key}")
    private String encryptionKey;

    private String encryptionCipher = "AES";

    private Key key;
    private Cipher cipher;

    private Key getKey() {
    	//If No Key Is Provided While Run Time The Key Will Be Provided
        if (key == null)
            key = new SecretKeySpec(encryptionKey.getBytes(), encryptionCipher);
        return key;
    }

    private Cipher getCipher() throws GeneralSecurityException {
    	//If No Cipher Is Provided While RunTime The Cipher Will Be Provided
        if (cipher == null)
            cipher = Cipher.getInstance(encryptionCipher);
        return cipher;
    }

    private void initCipher(int encryptMode) throws GeneralSecurityException {
    	//Which Acts As The Initiation For Encrypt And Decrypt Mode 
        getCipher().init(encryptMode, getKey());
    }

    //Used To Throw Checked Exception(Occurs At Compile Time Where Unchecked Are Run Time)
    @SneakyThrows
    @Override	//Overrideing The Default Method Provided By The Attribute Convertor
    public String convertToDatabaseColumn(Object attribute) {
    	//Is The DataStoring Contains Attribute Null Return null
        if (attribute == null)
            return null;
        //Then If It Contains Value It Enters The Cipher Encrypt Mode Any Occurs It Will Catch As GeneralSeurity Exception
        try {
			initCipher(Cipher.ENCRYPT_MODE);
		} 
        catch (GeneralSecurityException e) {
			e.printStackTrace();
		}
        //Then The Attribute Is Undergo Serialization Which Converts The Data Into Bytes
        byte[] bytes = SerializationUtils.serialize(attribute);
        try {
        	//Base64 Encoder And Decoder Which Used To Convert Binary Data Into Text Format
			return Base64.getEncoder().encodeToString(getCipher().doFinal(bytes));
		} 
		catch (GeneralSecurityException e) {
			e.printStackTrace();
		}
        //After The Process The Attribute Will Be Encrypted And Stored In Db
		return encryptionCipher;
    }

  //Used To Throw Checked Exception(Occurs At Compile Time Where Unchecked Are Run Time)
    @SneakyThrows
    @Override //Overrideing The Default Method Provided By The Attribute Convertor
    public Object convertToEntityAttribute(String dbData) {
    	//Retriving The Data In Db When Data Is Null Returns Null
        if (dbData == null)
            return null;
        
        //If Data Enter Into The Cipher Init Which Is Decrypt Mode
        try {
			initCipher(Cipher.DECRYPT_MODE);
		} catch (GeneralSecurityException e) {
			e.printStackTrace();
		}
        //After The Data Is Serialized Then Setting Up The Serialized Object As null
        byte[] bytes = null;
        //And Using Base64 Decoder The Data Will Be Decoded In The Plain text
		try {
			bytes = getCipher().doFinal(Base64.getDecoder().decode(dbData));
		} catch (GeneralSecurityException e) {
			e.printStackTrace();
		}
		//Then The Object Will Be Retreived 
        return SerializationUtils.deserialize(bytes);
    }
}
