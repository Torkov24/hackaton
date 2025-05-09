import { Navigate } from 'react-router-dom';
import { useMsal } from "@azure/msal-react";

const ProtectedRoute = ({ children }) => {
  const { accounts } = useMsal();
  return accounts.length > 0 ? children : <Navigate to="/" />;
};

export default ProtectedRoute; 