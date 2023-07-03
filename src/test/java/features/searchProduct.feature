Feature: Search and Place the order for Products
@offerPage
Scenario Outline: Search Experience for product search in both home and Offer page

Given User is on GreenCart Landing page
When user searched with Shortname <Name> and extracted actual name of product
#When user searched with Shortname and extracted actual name of product
Then user searched for <Name> shortname in offers page to check if product exist
And validate product name in offers page matches with Landing Page

Examples:
| Name |
| Tom |
| Beet |