import { BrowserRouter as Router, Routes, Route, Navigate } from 'react-router-dom';
import { useMsal } from "@azure/msal-react";
import { loginRequest } from './auth/msalConfig';
import { useTranslation } from 'react-i18next';
import {
  AppBar,
  Toolbar,
  Typography,
  Button,
  Container,
  Box,
  Paper,
  Select,
  MenuItem,
  FormControl,
  InputLabel,
  useTheme,
} from '@mui/material';
import ProfileForm from './components/ProfileForm';
import ProtectedRoute from './components/ProtectedRoute';

const Navigation = () => {
  const { instance, accounts } = useMsal();
  const { t, i18n } = useTranslation();
  const theme = useTheme();

  const handleLogin = () => {
    instance.loginPopup(loginRequest).catch(error => {
      console.error("Login failed:", error);
    });
  };

  const handleLogout = () => {
    instance.logoutPopup().catch(error => {
      console.error("Logout failed:", error);
    });
  };

  const handleLanguageChange = (event) => {
    i18n.changeLanguage(event.target.value);
  };

  return (
    <AppBar position="static" elevation={0}>
      <Toolbar>
        <Typography variant="h6" component="div" sx={{ flexGrow: 1 }}>
          {t('app.name')}
        </Typography>
        
        <FormControl size="small" sx={{ minWidth: 120, mx: 2 }}>
          <InputLabel id="language-select-label">Language</InputLabel>
          <Select
            labelId="language-select-label"
            id="language-select"
            value={i18n.language}
            label="Language"
            onChange={handleLanguageChange}
          >
            <MenuItem value="en">English</MenuItem>
            <MenuItem value="mk">Македонски</MenuItem>
          </Select>
        </FormControl>

        {accounts.length > 0 ? (
          <Button 
            color="inherit" 
            onClick={handleLogout}
            id="logout-button"
          >
            {t('auth.logout')}
          </Button>
        ) : (
          <Button 
            color="inherit" 
            onClick={handleLogin}
            id="login-button"
          >
            {t('auth.login')}
          </Button>
        )}
      </Toolbar>
    </AppBar>
  );
};

const Home = () => {
  const { accounts } = useMsal();
  const { t } = useTranslation();
  const theme = useTheme();

  return (
    <Container>
      <Paper elevation={0} sx={{ p: 4, mt: 4, textAlign: 'center' }}>
        <Typography variant="h4" gutterBottom>
          {t('home.welcome')}
        </Typography>
        <Typography variant="body1" color="text.secondary" paragraph>
          {accounts.length > 0 ? t('home.loggedIn') : t('home.notLoggedIn')}
        </Typography>
      </Paper>
    </Container>
  );
};

const Dashboard = () => {
  const { accounts } = useMsal();
  const { t } = useTranslation();
  const theme = useTheme();

  return (
    <Container>
      <Paper elevation={0} sx={{ p: 4, mt: 4 }}>
        <Typography variant="h4" gutterBottom>
          {t('dashboard.welcome', { name: accounts[0]?.name })}
        </Typography>
        <Typography variant="body1" color="text.secondary" paragraph>
          {t('dashboard.description')}
        </Typography>
        <ProfileForm />
      </Paper>
    </Container>
  );
};

const App = () => {
  const { accounts } = useMsal();

  return (
    <Router>
      <Box sx={{ flexGrow: 1 }}>
        <Navigation />
        <Routes>
          <Route 
            path="/dashboard" 
            element={
              <ProtectedRoute>
                <Dashboard />
              </ProtectedRoute>
            } 
          />
          <Route 
            path="/" 
            element={
              accounts.length > 0 ? (
                <Navigate to="/dashboard" replace />
              ) : (
                <Home />
              )
            } 
          />
        </Routes>
      </Box>
    </Router>
  );
};

export default App;
