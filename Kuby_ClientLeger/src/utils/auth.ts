import { jwtDecode } from 'jwt-decode';

interface DecodedToken {
    iss: string;
    iat: number;
    exp: number;
    userId: number;
    firstname: number;
    name: string;
    phone: string;
    email: string;
    type: number;
    admin: boolean;
}

export interface Ids {
    userId: number;
    firstname: number;
    name: string;
    phone: string;
    email: string;
    type: number;
    admin: boolean;
}

export function isTokenValid(token: string): boolean {
    try {
        const decodedToken: DecodedToken = jwtDecode(token);
        const currentTime = Math.floor(Date.now() / 1000); // Heure actuelle en secondes
        // return false;
        return decodedToken.exp !== undefined && decodedToken.exp > currentTime;
    } catch (error) {
        console.error('Erreur lors de la validation du token :', error);
        return false;
    }
}


export function getIds(token: string): Ids {
    try {
        const decodedToken: DecodedToken = jwtDecode(token);
        const currentTime = Math.floor(Date.now() / 1000); // Heure actuelle en secondes
        // return false;
        const Ids: Ids = {userId: decodedToken.userId, profileId:decodedToken.profileId, profile: decodedToken.profile, department: decodedToken.department, companyId: decodedToken.companyId}
        return Ids;
    } catch (error) {
        console.error('Erreur lors de la validation du token :', error);
        const Ids: Ids = {userId: 0, profileId:0, profile: '', department: '', companyId: 0};
        return Ids;
    }
}