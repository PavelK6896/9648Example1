describe('playlist', function () { // несколько тестов
    var playlist; //для инжекта

    // karma start

    beforeEach(function () {
        module('app');

        inject(function (_playlist_) { // инжектим
            playlist = _playlist_;
        });
    });

    it("!!", function () {
        expect(2).toEqual(2);
    })

    it('should get correct playlist name', function () { //тест 1
      expect(playlist.name).toEqual('Metallica');
    });

    it('should get list of tracks', function () {
      var tracks = [
        {
          id: 1,
          name: 'Track 01'
        },
        {
          id: 2,
          name: 'Track 02'
        }
      ];
      expect(playlist.getTracks()).toEqual(tracks);
    });

});
