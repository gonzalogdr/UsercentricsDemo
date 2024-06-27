1. Good morning everybody, this is Gonzalo, sales engineer for Usercentrics. I am in charge of managing internal and external pre-sales 
processes, owning sales projects, setting up POCs and demos, RFIs, supporting and testing implementations both technically and commercially, 
among many other tasks.
Nowadays, data privacy is something really important when talking about the digital age. It is critical the individuals can take control 
over the way their data is collected, shared, managed, otherwise they would be exposed to potential breaches provoking identity theft for example. 
Thanks to some established laws and guidelines we have many different data regulations, highlighting GDPR (General Data Protection Regulation) 
in Europe.

It is at this point where Usercentrics, as a company, takes the lead, a CMP (consent management platform) that helps companies to 
comply with the regulations described previously, providing support to collect and manage consents from users.

Some of our customers are: Telefónica, T-Mobile, Huawei, Rolls-Royce or ING.

As an entry point, we can say that the purpose of this meeting is to show you how to implement the Usercentrics SDK and configure the consent banner
depending on the users' location.


2. These are the bullet points we'll go through this presentation.


3. Before starting with the implementation of the SDK, and in collation to the purpose of the meeting
is important to know what are the Usercentrics Geolocation Rulesets.
The definition is very simple, they allow us to set different banner configurations depending on specific locations.
They offer trust and transparency, mitigate no compliance risks and improve user-experience based on their location.

We have regional rulesets: This set of rules allow to target users based on their location
Global ruleset: Act as a fallback if the user location is not targeting any regional ruleset.

I will show you how to configure it from the Admin UI.
"DEMO TIME GEOLOCATION RULESETS FROM ADMIN UI"

4. Once we have all this context, let's start with the Usercentrics Android SDK Implementation.

We can choose between Usercentrics UI and Usercentrics CORE. 
Usercentrics CORE provides APIs to customize your own UI. Furthermore, provides full
control over the management process and alignmente to your user/brand needs.
On the other side, we have Usercentrics UI SDK, a ready-to-use UI solution. It offers a really quick setup 
and a powerful UI design among many other benefits.

We will be focusing on the Usercentrics UI SDK, but will be mentioning Usercentrics CORE when needed.

5. Diapo 7. Talk about the implementation of the library

6. Let's move forward. As you already may know what are the geolocation rulesets, let's talk about the rulesetID.
In simple words, we can say is our Geolocation Ruleset ID. THis ID will be used at the moment 
we initialize the Usercentrics SDK. We can choose whether to use the SettingsID (hooks an specific configuration) or rulesetID(our case).
Let me show you how to initialize the SDK from the code (Show Admin UI, where to get rulesetID, and then move to Android Studio
to show SDK init, isReady, etc... //region Usercentrics initialization).

7. Once we know how to initialize the Usercentrics SDK, let's talk about the Consent Banner COnfiguration.
We have 3 different options:
   - Usercentrics UI: owning all the complexity, and highly customizable.
   - Your own UI: Using the Usercentrics Core, you will be able to render your own consent banner.
   - Hybrid: Combining both you will enhance your solution (Your own first layer, and Usercentrics UI for the 2nd).

8. As we said before the goal of this presentation apart from the Usercentrics implementation, is to show a different banner configuration
depending on the users' location. For that let's see how we can configure it:
   - Remote Customization: I will show you from the Admin UI
   - Programmatic Customization: I will show you from the code. With the programmatic customization, we 'unlock' the ABTesting, I will show you later.
With the geolocation rulesets we can define regions and show different banner configurations depending on the user location, 
as long as we are "defining" the country in the mark it belongs to.
   - GDPR: Citizens living in the EU regardless their citizenship.
   - TCF2.2: IAB created the GDPR Transparency and Consent Framework to support vendors, publishers in being compliant with GDPR regulations.
   - California Consumer Privacy Act (CCPA)
   - Brazil’s Lei Geral de Proteção de Dados (LGPD): People in Brazil.
- If we are using the remote customization with Usercentrics UI, we simply need to define the regional settings targeting an specific configuration.
- On the other hand, in case we are using Usercentrics UI programmatic customization or Usercentrics CORE, 
this situation turns out a bit more difficult, and in my opinion, less recommended. This is due to the fact that we should be referring to Android 
SDK APIs in order to detect user's location, and set an specific banner configuration dependant on that location, which could lead to more problems.
For instance, if we are under the TCF IAB mark, our banner configuration
would need to be certified by the IAB.

As I said before, the best approach for me would be to refer to Usercentrics UI, relying on the powerful UI design and the setup we are offered, 
as long as we don't need to configure our own banner for specific reasons such as brand alignment, business requirements, etc.

Is it possible to create under the Usercentrics CORE an API to configure somehow the banner depending on the country?
THe main difficulty for me is to consider every country, and set a different banner configuration for each of those countries.

I would ask customers:

- Do you think Usercentrics SDK documentation is complete? Do you have any doubt?
- What's the most challenging part of the implementation you find?
- Do you think Usercentrics CORE is easy to use?
- What do you prefer? Usercentrics SDK or Usercentrics CORE?

ANd these questions bring me to the end of my presentation.

I hope everything was clear and understandable, and glad to answer any question you may have.