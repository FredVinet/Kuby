export const API_ENDPOINTS = {
    // address
    GET_ALL_ADRESSES: '/adresses/getAllAdresses',
    GET_ADRESSE_BY_ID: '/adresses/getOneAdress/',
    CREATE_ADRESSES: '/adresses/createAdress',
    UPDATE_ADRESSES: '/adresses/updateAdress/',
    DELETE_ADRESSES: '/adresses/deleteAdress/',

    // article
    GET_ALL_ARTICLES: '/articles/getAllArticles',
    GET_ARTICLES_BY_ID: '/articles/getOneArticle/',
    CREATE_ARTICLE: '/articles/createArticle',
    UPDATE_ARTICLE: '/articles/updateArticle/',
    DELETE_ARTICLE: '/articles/deleteArticle/',

    // family
    GET_ALL_FAMILIES: '/articles/getAllFamilies',
    GET_FAMILY_BY_ID: '/articles/getOneFamily/',
    CREATE_FAMILY: '/articles/createFamily',
    UPDATE_FAMILY: '/articles/updateFamily/',
    DELETE_FAMILY: '/articles/deleteFamily/',

    // grape
    GET_ALL_GRAPES: '/articles/getAllGrapes',
    GET_GRAPE_BY_ID: '/articles/getOneGrape/',
    CREATE_GRAPE: '/articles/createGrape',
    UPDATE_GRAPE: '/articles/updateGrape/',
    DELETE_GRAPE: '/articles/deleteGrape/',

    // localisation
    GET_ALL_LOCALISATIONS: '/localisations/getAllLocalisations',
    GET_LOCALISATION_BY_ID: '/localisations/getOneLocalisation/',
    CREATE_LOCALISATION: '/localisations/createLocalisation',
    UPDATE_LOCALISATION: '/localisations/updateLocalisation/',
    DELETE_LOCALISATION: '/localisations/deleteLocalisation/',

    // orders 
    GET_ALL_ORDERS: '/orders/getAllOrders',
    GET_ORDER_BY_ID: '/orders/getOneOrder/',
    CREATE_ORDER: '/orders/createOrder',
    UPDATE_ORDER: '/orders/updateOrder/',
    DELETE_ORDER: '/orders/deleteOrder/',

    // order_items
    GET_ALL_ORDER_ITEMS: '/orderItems/getAllOrderItems',
    GET_ORDER_ITEM_BY_ID: '/orderItems/getOrderItemById/',
    CREATE_ORDER_ITEM: '/orderItems/createOrderItems',
    UPDATE_ORDER_ITEM: '/orderItems/updateOrderItem/',
    DELETE_ORDER_ITEM: '/orderItems/deleteOrderItem/',
    
    // stock
    GET_ALL_STOCKS: '/articles/getAllStocks',
    GET_STOCK_BY_ID: '/articles/getOneStock/',
    CREATE_STOCK: '/articles/createStock',
    UPDATE_STOCK: '/articles/updateStock/',
    DELETE_STOCK: '/articles/deleteStock/',

    // supplier_article
    GET_ALL_SUPPLIER_ARTICLES: '/articles/getAllSupplierArticles',
    GET_SUPPLIER_ARTICLE_BY_ID: '/articles/getOneSupplierArticle/',
    CREATE_SUPPLIER_ARTICLE: '/articles/createSupplierArticle',
    UPDATE_SUPPLIER_ARTICLE: '/articles/updateSupplierArticle/',
    DELETE_SUPPLIER_ARTICLE: '/articles/deleteSupplierArticle/',

    // users
    GET_ALL_USERS: '/users/getAllUsers',
    GET_USER_BY_ID: '/users/getOneUser/',
    GET_USERS_BY_TYPE: '/users/getUsersByType',
    CREATE_USER: '/users/createUser',
    UPDATE_USER: '/users/updateUser/',
    DELETE_USER: '/users/deleteUser/',

    // Auth
    LOGIN: '/users/login',
    CHECK_FIRST_LOGIN: '/auth/checkFirstLogin.php',
    SET_NEW_PASSWORD: '/auth/setNewPassword.php',
    UPDATE_PASSWORD: '/auth/updatePassword.php',
    CHANGE_PASSWORD: '/auth/changePassword.php',
}
  