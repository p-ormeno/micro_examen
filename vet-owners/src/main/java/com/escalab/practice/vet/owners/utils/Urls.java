package com.escalab.practice.vet.owners.utils;

/**
 * The Class Urls.
 */
public class Urls {

	/**
     * Instantiates a new urls.
     */
    private Urls() {
    	super();
    }
    
    
    /** The Constant PET_OWNER. */
    public static final String PET_OWNER = "/owners";
    
    /** The Constant PET_RECORD. */
    public static final String PET_RECORD = "/pets";
    
    /** The Constant PERSONNEL. */
    public static final String PERSONNEL = "/personnel";
    
    /** The Constant NEW_PET. */
    public static final String NEW_PET = "/new-pet";
    
    /** The Constant UPDATE_PET. */
    public static final String UPDATE_PET = "/update-pet";
    
    /** The Constant ADD_WEIGHT. */
    public static final String ADD_WEIGHT = "/add-weight";
    
    /** The Constant GET_WEIGHT. */
    public static final String GET_WEIGHT = "/get-weight/{petId}";
    
    /** The Constant PET_BY_NAME. */
    public static final String PET_BY_NAME = "/find-pet/{name}";
    
    /** The Constant NEW_OWNER. */
    public static final String NEW_OWNER = "/new-owner";
    
    /** The Constant UPDATE_OWNER. */
    public static final String UPDATE_OWNER = "/update-owner";
    
    /** The Constant FIND_OWNER. */
    public static final String FIND_OWNER = "/find-owner/{rut}";
    
    /** The Constant PET_BY_OWNER. */
    public static final String PET_BY_OWNER = "/find-pet/{rut}";
}
