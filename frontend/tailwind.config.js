module.exports = {
  purge: [],
  darkMode: false, // or 'media' or 'class'
  theme: {
    
    extend: {
      colors:{
        'kolor': '#191e23',
      },
      backgroundImage:{
        'homeBackground': "url('assets/backv6.jpg')",
        'loginBackground': "url(assets/loginBack.jpg)",
        'track': "url(assets/trasaV2.png)",
      },
      fontFamily: {
        myFonts: ['Red Hat Mono']
      }
    },
  },
  variants: {
    extend: {},
  },
  plugins: [],
}
