package org.ff4j.store;

/*
 * #%L ff4j-core %% Copyright (C) 2013 Ff4J %% Licensed under the Apache License, Version 2.0 (the "License"); you may not use
 * this file except in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS"
 * BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language
 * governing permissions and limitations under the License. #L%
 */

/**
 * Specialization of a Feature store to add sql query.
 * 
 * @author <a href="mailto:cedrick.lunven@gmail.com">Cedrick LUNVEN</a>
 */
public interface JdbcFeatureStoreConstants {

    /** sql query expression */
    String SQLQUERY_ALLFEATURES = "SELECT UID,ENABLE,DESCRIPTION FROM FF4J_FEATURES";

    /** sql query expression */
    String SQLQUERY_GET_FEATURE_BY_ID = "SELECT UID,ENABLE,DESCRIPTION FROM FF4J_FEATURES WHERE UID = ?";

    /** sql query expression */
    String SQL_EXIST = "SELECT COUNT(UID) FROM FF4J_FEATURES WHERE UID = ?";

    /** sql query expression */
    String SQL_DISABLE = "UPDATE FF4J_FEATURES SET ENABLE = 0 WHERE UID = ?";

    /** sql query expression */
    String SQL_ENABLE = "UPDATE FF4J_FEATURES SET ENABLE = 1 WHERE UID = ?";

    /** sql query expression */
    String SQL_CREATE = "INSERT INTO FF4J_FEATURES(UID, ENABLE, DESCRIPTION) VALUES(?, ?, ?)";

    /** sql query expression */
    String SQL_DELETE = "DELETE FROM FF4J_FEATURES WHERE UID = ?";

    /** sql query expression */
    String SQL_UPDATE = "UPDATE FF4J_FEATURES SET DESCRIPTION = ? WHERE UID = ?";

    /** sql query expression */
    String SQL_ADD_ROLE = "INSERT INTO FF4J_ROLES(FEAT_UID, ROLE_NAME) VALUES (?,?)";

    /** sql query expression */
    String SQL_DELETE_ROLE = "DELETE FROM FF4J_ROLES WHERE FEAT_UID = ? AND ROLE_NAME = ?";

    /** sql query expression */
    String SQL_GET_ROLES = "SELECT ROLE_NAME FROM FF4J_ROLES WHERE FEAT_UID = ?";

    /** sql query expression */
    String SQL_GET_ALLROLES = "SELECT FEAT_UID,ROLE_NAME FROM FF4J_ROLES";

}
