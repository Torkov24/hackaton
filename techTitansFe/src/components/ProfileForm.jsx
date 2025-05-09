import React from 'react';
import {
  TextField,
  Button,
  Box,
  Typography,
  Paper,
  Alert,
} from '@mui/material';
import { useFormValidation } from '../hooks/useFormValidation';
import { createUserProfileSchema } from '../utils/validation';
import { useTranslation } from 'react-i18next';

const ProfileForm = () => {
  const { t } = useTranslation();
  const {
    formData,
    errors,
    touched,
    handleChange,
    handleBlur,
    validateForm,
    resetForm
  } = useFormValidation(createUserProfileSchema(t));

  const handleSubmit = (e) => {
    e.preventDefault();
    if (validateForm()) {
      // Handle form submission
      console.log('Form data:', formData);
      resetForm();
    }
  };

  return (
    <Paper elevation={0} sx={{ p: 4, maxWidth: 500, mx: 'auto', mt: 4 }}>
      <Typography variant="h5" component="h2" gutterBottom>
        {t('profile.title')}
      </Typography>
      
      <Box component="form" onSubmit={handleSubmit} noValidate>
        <TextField
          fullWidth
          margin="normal"
          label={t('profile.name')}
          name="name"
          value={formData.name || ''}
          onChange={handleChange}
          onBlur={handleBlur}
          error={touched.name && Boolean(errors.name)}
          helperText={touched.name && errors.name}
          id="profile-name-input"
        />

        <TextField
          fullWidth
          margin="normal"
          label={t('profile.email')}
          name="email"
          type="email"
          value={formData.email || ''}
          onChange={handleChange}
          onBlur={handleBlur}
          error={touched.email && Boolean(errors.email)}
          helperText={touched.email && errors.email}
          id="profile-email-input"
        />

        <TextField
          fullWidth
          margin="normal"
          label={t('profile.password')}
          name="password"
          type="password"
          value={formData.password || ''}
          onChange={handleChange}
          onBlur={handleBlur}
          error={touched.password && Boolean(errors.password)}
          helperText={touched.password && errors.password}
          id="profile-password-input"
        />

        <TextField
          fullWidth
          margin="normal"
          label={t('profile.confirmPassword')}
          name="confirmPassword"
          type="password"
          value={formData.confirmPassword || ''}
          onChange={handleChange}
          onBlur={handleBlur}
          error={touched.confirmPassword && Boolean(errors.confirmPassword)}
          helperText={touched.confirmPassword && errors.confirmPassword}
          id="profile-confirm-password-input"
        />

        {Object.keys(errors).length > 0 && (
          <Alert severity="error" sx={{ mt: 2 }}>
            {t('profile.formErrors')}
          </Alert>
        )}

        <Box sx={{ mt: 3, display: 'flex', gap: 2 }}>
          <Button
            type="submit"
            variant="contained"
            color="primary"
            id="profile-submit-button"
          >
            {t('profile.saveChanges')}
          </Button>
          <Button
            type="button"
            variant="outlined"
            onClick={resetForm}
            id="profile-reset-button"
          >
            {t('profile.reset')}
          </Button>
        </Box>
      </Box>
    </Paper>
  );
};

export default ProfileForm; 