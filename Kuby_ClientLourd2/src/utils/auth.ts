import { jwtDecode } from 'jwt-decode';

interface DecodedToken {
  iss: string;
  iat: number;
  exp: number;
  userId: number;
  email: string;
  role: string;
}

export interface Ids {
  userId: number;
  email: string;
  role: string;
}

export function isTokenValid(token: string): boolean {
  try {
    const decodedToken: DecodedToken = jwtDecode(token);
    const currentTime = Math.floor(Date.now() / 1000); // Heure actuelle en secondes
    return decodedToken.exp !== undefined && decodedToken.exp > currentTime;
  } catch (error) {
    console.error('Erreur lors de la validation du token :', error);
    return false;
  }
}

export function getIds(token: string): Ids {
  try {
    const decodedToken: DecodedToken = jwtDecode(token);
    return {
      userId: decodedToken.userId,
      email: decodedToken.email,
      role: decodedToken.role,
    };
  } catch (error) {
    console.error('Erreur lors de la validation du token :', error);
    return {
      userId: 0,
      email: '',
      role: '',
    };
  }
}