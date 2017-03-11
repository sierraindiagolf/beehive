import { BeehivePage } from './app.po';

describe('beehive App', function() {
  let page: BeehivePage;

  beforeEach(() => {
    page = new BeehivePage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
