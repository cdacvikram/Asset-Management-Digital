package com.management.asset.exception;

/**
 * ExistingShopException class to catch the exception while cloning the object 
 * 
 * @author Vikram
 *
 */
public class AssetMgmtException extends Exception{


    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = -1332650372805036202L;

    /**
     * Instantiates a existing Shop Exception.
     *
     * @param cause the cause
     */
    public AssetMgmtException(String cause) {
        super(cause);
    }

}
