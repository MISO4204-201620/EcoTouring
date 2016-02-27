import {describe, it, expect, beforeEachProviders, inject} from 'angular2/testing';
import {EcotouringwebApp} from '../app/ecotouringweb';

beforeEachProviders(() => [EcotouringwebApp]);

describe('App: Ecotouringweb', () => {
  it('should have the `defaultMeaning` as 42', inject([EcotouringwebApp], (app: EcotouringwebApp) => {
    expect(app.defaultMeaning).toBe(42);
  }));

  describe('#meaningOfLife', () => {
    it('should get the meaning of life', inject([EcotouringwebApp], (app: EcotouringwebApp) => {
      expect(app.meaningOfLife()).toBe('The meaning of life is 42');
      expect(app.meaningOfLife(22)).toBe('The meaning of life is 22');
    }));
  });
});

