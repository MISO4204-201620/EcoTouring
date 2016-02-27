export class EcotouringwebPage {
  navigateTo() { return browser.get('/'); }
  getParagraphText() { return element(by.css('Ecotouringweb-app p')).getText(); }
}
