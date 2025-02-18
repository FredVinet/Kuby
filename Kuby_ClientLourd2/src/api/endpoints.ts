export const API_ENDPOINTS = {
    // address
    GET_ALL_ADRESSES: '/adresses/getAllAdresses',
    GET_ADRESSE_BY_ID: '/adresses/getOneAdress/',
    GET_ADRESSES_BY_USER_ID: '/users/{userId}/adresses',
    CREATE_ADRESSES: '/adresses/createAdress',
    UPDATE_ADRESSES: '/adresses/updateAdress/:id',
    DELETE_ADRESSES: '/adresses/deleteAdress/:id',

    // article
    GET_ALL_ARTICLES: '/articles/getAllArticles',
    GET_ALL_ARTICLES_DETAILS: '/articles/getAllArticlesDetails',
    GET_ARTICLES_BY_ID: '/articles/getOneArticle/',
    CREATE_ARTICLE: '/articles/createArticle/:id',
    UPDATE_ARTICLE: '/articles/updateArticle/:id',
    DELETE_ARTICLE: '/articles/deleteArticle/:id',

    // family
    GET_ALL_FAMILIES: '/families/getAllFamilies',
    GET_FAMILY_BY_ID: '/families/getOneFamily/',
    CREATE_FAMILY: '/families/createFamily',
    UPDATE_FAMILY: '/families/updateFamily/',
    DELETE_FAMILY: '/families/deleteFamily/',

    // grape
    GET_ALL_GRAPES: '/grapes/getAllGrapes',
    GET_GRAPE_BY_ID: '/grapes/getOneGrape/',
    CREATE_GRAPE: '/grapes/createGrape',
    UPDATE_GRAPE: '/grapes/updateGrape/',
    DELETE_GRAPE: '/grapes/deleteGrape/',

    // localisation
    GET_ALL_LOCALISATIONS: '/localisations/getAllLocalisations',
    GET_LOCALISATION_BY_ID: '/localisations/getOneLocalisation/',
    CREATE_LOCALISATION: '/localisations/createLocalisation',
    UPDATE_LOCALISATION: '/localisations/updateLocalisation/',
    DELETE_LOCALISATION: '/localisations/deleteLocalisation/',
    GET_LOCALISATION_BY_ADRESS_ID: '/localisations/getLocalisationByAdressId/{adressId}',

    // orders 
    GET_ALL_ORDERS: '/orders/getAllOrders',
    GET_ALL_ORDERS_DETAILS: '/orders/getAllOrdersDetails',
    GET_ORDER_BY_ID: '/orders/getOneOrder/',
    CREATE_ORDER: '/orders/createOrder',
    UPDATE_ORDER: '/orders/updateOrder/:id',
    DELETE_ORDER: '/orders/deleteOrder/:id',

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
    GET_ALL_SUPPLIER_ARTICLES: '/supplierarticles/getAllSupplierArticles',
    GET_SUPPLIER_ARTICLE_BY_ID: '/supplierarticles/getOneSupplierArticle/',
    CREATE_SUPPLIER_ARTICLE: '/supplierarticles/createSupplierArticle',
    UPDATE_SUPPLIER_ARTICLE: '/supplierarticles/updateSupplierArticle/',
    DELETE_SUPPLIER_ARTICLE: '/supplierarticles/deleteSupplierArticle/',

    // users
    GET_ALL_USERS: '/users/getAllUsers',
    GET_USER_BY_ID: '/users/getOneUser/',
    GET_USERS_BY_TYPE: '/users/getUsersByType',
    CREATE_USER: '/users/createUser',
    UPDATE_USER: '/users/updateUser/:id',
    DELETE_USER: '/users/deleteUser/:id',

    // Auth
    LOGIN: '/users/login',
    CHECK_FIRST_LOGIN: '/auth/checkFirstLogin.php',
    SET_NEW_PASSWORD: '/auth/setNewPassword.php',
    UPDATE_PASSWORD: '/auth/updatePassword.php',
    CHANGE_PASSWORD: '/auth/changePassword.php',
}
  