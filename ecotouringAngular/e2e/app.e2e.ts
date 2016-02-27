/// <reference path="../typings/main.d.ts" />

import { EcotouringwebPage } from './app.po';

describe('ecotouringweb App', function() {
  let page: EcotouringwebPage;

  beforeEach(() => {
    page = new EcotouringwebPage();
  })

  it('should display message saying app works', () => {
    page.navigateTo()
    expect(page.getParagraphText()).toEqual('ecotouringweb Works!');
  });
});
