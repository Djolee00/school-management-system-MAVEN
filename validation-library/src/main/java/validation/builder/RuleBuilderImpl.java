package validation.builder;

import validation.abstraction.AbstractValidator;
import validation.rule.Rule;
import validation.rule.MatchRegexRule;
import validation.rule.MaxLengthRule;
import validation.rule.MinLengthRule;
import validation.rule.NotEmptyRule;


public class RuleBuilderImpl implements RuleBuilder {

    private AbstractValidator abstractValidator;
    private Object propertyValue;
    private Rule lastRule;

    public RuleBuilderImpl(AbstractValidator abstractValidator, Object property) {
        this.abstractValidator = abstractValidator;
        this.propertyValue = property;
    }

    @Override
    public RuleBuilder maxLength(int maxLength) {
        Rule rule = new MaxLengthRule(maxLength, propertyValue);
        abstractValidator.getRules().add(rule);
        lastRule = rule;
        return this;
    }

    @Override
    public RuleBuilder minLength(int minLength) {
        Rule rule = new MinLengthRule(minLength, propertyValue);
        abstractValidator.getRules().add(rule);
        lastRule = rule;
        return this;
    }

    @Override
    public RuleBuilder notEmpty() {
        Rule rule = new NotEmptyRule( propertyValue);
        abstractValidator.getRules().add(rule);
        lastRule = rule;
        return this;
    }

    @Override
    public RuleBuilder matchesRegex(String regex) {
        Rule rule = new MatchRegexRule( propertyValue,regex);
        abstractValidator.getRules().add(rule);
        lastRule = rule;
        return this;
    }

    @Override
    public RuleBuilder withMessage(String message) {
        if(lastRule!=null){
            lastRule.setErrorMessage(message);
        }
        return this;
    }

    public AbstractValidator getAbstractValidator() {
        return abstractValidator;
    }

    public void setAbstractValidator(AbstractValidator abstractValidator) {
        this.abstractValidator = abstractValidator;
    }

    public Object getPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(Object propertyValue) {
        this.propertyValue = propertyValue;
    }

    public Rule getLastRule() {
        return lastRule;
    }

}
