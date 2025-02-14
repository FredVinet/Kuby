export const API_ENDPOINTS = {
    // address
    GET_ALL_ADRESSES: '/adresses/getAllAdresses',
    GET_ADRESSE_BY_ID: '/adresses/getOneAdress/{adressId}',
    CREATE_ADRESSES: '/adresses/createAdress',
    UPDATE_ADRESSES: '/adresses/updateAdress/{adressId}',
    DELETE_ADRESSES: '/adresses/deleteAdress/{adressId}',

    // article
    GET_ALL_ARTICLES: '/articles/getAllArticles',
    GET_ARTICLES_BY_ID: '/articles/getOneArticle/{articleId}',
    CREATE_ARTICLE: '/articles/createArticle',
    UPDATE_ARTICLE: '/articles/updateArticle/',
    DELETE_ARTICLE: '/articles/deleteArticle/',

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
    GET_LOCALISATION_BY_ADRESS_ID: '/localisations/getLocalisationByAdressId/{adressId}',
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
    GET_ALL_STOCKS: '/stocks/getAllStocks',
    GET_STOCK_BY_ID: '/stocks/getOneStock/',
    CREATE_STOCK: '/stocks/createStock',
    UPDATE_STOCK: '/stocks/updateStock/',
    DELETE_STOCK: '/stocks/deleteStock/',

    // supplier_article
    GET_ALL_SUPPLIER_ARTICLES: '/supplierarticles/getAllSupplierArticles',
    GET_SUPPLIER_ARTICLE_BY_ID: '/supplierarticles/getOneSupplierArticle/',
    CREATE_SUPPLIER_ARTICLE: '/supplierarticles/createSupplierArticle',
    UPDATE_SUPPLIER_ARTICLE: '/supplierarticles/updateSupplierArticle/',
    DELETE_SUPPLIER_ARTICLE: '/supplierarticles/deleteSupplierArticle/',

    // users
    GET_ALL_USERS: '/users/getAllUsers',
    GET_USER_BY_ID: '/users/getOneUser/{userId}',
    GET_ADRESSES_BY_USER_ID: '/users/{userId}/adresses',
    GET_ORDERS_BY_USER_ID: '/users/{userId}/orders',
    CREATE_USER_ADRESSES: '/adresses/createUserAdress/{userId}',
    CREATE_USER: '/users/createUser',
    UPDATE_USER: '/users/updateUser/{userId}',
    DELETE_USER: '/users/deleteUser/{userId}',
    UPDATE_PASSWORD: '/users/updatePassword/{userId}',

    // Auth
    LOGIN: '/users/login',
}
  