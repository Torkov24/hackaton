import { useState, useCallback } from 'react';

export const useFormValidation = (schema) => {
  const [formData, setFormData] = useState({});
  const [errors, setErrors] = useState({});
  const [touched, setTouched] = useState({});

  const handleChange = useCallback((e) => {
    const { name, value } = e.target;
    setFormData(prev => ({
      ...prev,
      [name]: value
    }));
  }, []);

  const handleBlur = useCallback((e) => {
    const { name } = e.target;
    setTouched(prev => ({
      ...prev,
      [name]: true
    }));
  }, []);

  const validateField = useCallback((name, value) => {
    const { error } = schema.extract(name).validate(value);
    if (error) {
      setErrors(prev => ({
        ...prev,
        [name]: error.details[0].message
      }));
    } else {
      setErrors(prev => {
        const newErrors = { ...prev };
        delete newErrors[name];
        return newErrors;
      });
    }
  }, [schema]);

  const validateForm = useCallback(() => {
    const { error } = schema.validate(formData, { abortEarly: false });
    if (error) {
      const newErrors = {};
      error.details.forEach((detail) => {
        const key = detail.path[0];
        newErrors[key] = detail.message;
      });
      setErrors(newErrors);
      return false;
    }
    setErrors({});
    return true;
  }, [schema, formData]);

  const resetForm = useCallback(() => {
    setFormData({});
    setErrors({});
    setTouched({});
  }, []);

  return {
    formData,
    errors,
    touched,
    handleChange,
    handleBlur,
    validateField,
    validateForm,
    resetForm,
    setFormData
  };
}; 