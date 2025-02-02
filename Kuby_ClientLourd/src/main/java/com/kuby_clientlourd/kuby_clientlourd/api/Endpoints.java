package com.kuby_clientlourd.kuby_clientlourd.api;

public enum Endpoints {
    // 🔹 Récupération des vins
    GET_ALL_WINES("/wines"),
    GET_WINE_BY_ID("/wine/byId/{id}"),
    GET_WINE_BY_WINE_FAMILY_ID("/wine/byWineFamily/{id}"),
    GET_WINE_BY_VARIETY_ID("/wine/byVariety/{id}"),
    GET_WINE_BY_TERROIR_ID("/wine/byTerroir/{id}"),
    GET_WINE_BY_YEAR("/wine/byYear"),
    GET_SUPPLIER_BY_WINE("/wine/SupplierByWine/{id}"),
    GET_ALL_FAMILIES("/wine/AllFamilly"),
    GET_ALL_VARIETIES("/wine/AllVariety"),
    GET_ALL_TERRORS("/wine/AllTerroir"),
    GET_WINE_QTY_BY_ID("/wine/quantity/{id}"),
    GET_WINE_QTY_BY_WINEFAMILY("/wine/quantity/byWineFamily/{id}"),
    GET_WINE_QTY_BY_VARIETY("/wine/quantity/byVariety/{id}"),
    GET_WINE_QTY_BY_TERROIR("/wine/quantity/byTerroir/{id}"),
    CREATE_WINE("/wine"),
    UPDATE_WINE("/wine/{id}"),
    UPDATE_WINE_QTY("/wine/quantity/{id}"),
    DELETE_WINE("/wine/{id}");

    private final String path;

    Endpoints(String path) {
        this.path = path;
    }

    // ✅ Retourne le chemin correct
    public String getPath() {
        return path;
    }

    // ✅ Remplace `{id}` par une valeur dynamique
    public String withParam(String param) {
        return path.replace("{id}", param);
    }

    // ✅ Remplace plusieurs paramètres dynamiques
    public String withParams(String... params) {
        String result = path;
        for (String param : params) {
            result = result.replaceFirst("\\{[^}]+}", param);
        }
        return result;
    }
}
