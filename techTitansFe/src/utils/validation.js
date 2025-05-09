import Joi from 'joi';

// Create schema with current translations
export const createUserProfileSchema = (t) => Joi.object({
  name: Joi.string()
    .min(2)
    .max(50)
    .required()
    .messages({
      'string.empty': t('profile.validation.nameRequired'),
      'string.min': t('profile.validation.nameMinLength'),
      'string.max': t('profile.validation.nameMaxLength')
    }),
  email: Joi.string()
    .email({ tlds: { allow: false } })
    .required()
    .messages({
      'string.empty': t('profile.validation.emailRequired'),
      'string.email': t('profile.validation.emailInvalid')
    }),
  password: Joi.string()
    .min(8)
    .pattern(new RegExp('^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])'))
    .messages({
      'string.empty': t('profile.validation.passwordRequired'),
      'string.min': t('profile.validation.passwordMinLength'),
      'string.pattern.base': t('profile.validation.passwordPattern')
    }),
  confirmPassword: Joi.string()
    .valid(Joi.ref('password'))
    .messages({
      'any.only': t('profile.validation.passwordsDoNotMatch')
    })
});

// Create login schema with current translations
export const createLoginSchema = (t) => Joi.object({
  email: Joi.string()
    .email({ tlds: { allow: false } })
    .required()
    .messages({
      'string.empty': t('profile.validation.emailRequired'),
      'string.email': t('profile.validation.emailInvalid')
    }),
  password: Joi.string()
    .required()
    .messages({
      'string.empty': t('profile.validation.passwordRequired')
    })
});

// Form validation helper function
export const validateForm = (schema, data) => {
  const { error } = schema.validate(data, { abortEarly: false });
  if (!error) return null;

  const errors = {};
  error.details.forEach((detail) => {
    const key = detail.path[0];
    errors[key] = detail.message;
  });

  return errors;
}; 